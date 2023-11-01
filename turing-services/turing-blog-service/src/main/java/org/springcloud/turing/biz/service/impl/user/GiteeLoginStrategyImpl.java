package org.springcloud.turing.biz.service.impl.user;

import org.springcloud.turing.biz.config.GiteeProperties;
import org.springcloud.turing.biz.dao.entity.GitUserInfoDO;
import org.springcloud.turing.biz.dao.entity.SocialTokenDO;
import org.springcloud.turing.biz.dao.entity.SocialUserInfoDO;
import org.springcloud.turing.biz.dao.entity.TokenDO;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.framework.starter.convention.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springcloud.turing.biz.common.constant.SocialLoginConstant.*;
import org.springcloud.turing.biz.common.enums.LoginTypeEnum;
/**
 * @descri Gitee登录策略
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Service("giteeLoginStrategyImpl")
public class GiteeLoginStrategyImpl extends AbstractLoginStrategyImpl {

    @Autowired
    private GiteeProperties giteeProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SocialTokenDO getSocialToken(CodeDTO codeDTO) {
        // 获取Gitee的Token
        TokenDO giteeToken = getGiteeToken(codeDTO.getCode());
        // 返回Gitee的Token信息
        return SocialTokenDO.builder()
                .accessToken(giteeToken.getAccess_token())
                .loginType(LoginTypeEnum.GITEE.getLoginType())
                .build();
    }

    @Override
    public SocialUserInfoDO getSocialUserInfo(SocialTokenDO socialToken) {
        Map<String, String> dataMap = new HashMap<>(1);
        // 请求参数
        dataMap.put(ACCESS_TOKEN, socialToken.getAccessToken());
        // Gitee用户信息
        GitUserInfoDO gitUserInfoVO = restTemplate.getForObject(giteeProperties.getUserInfoUrl(), GitUserInfoDO.class, dataMap);
        // 返回用户信息
        return SocialUserInfoDO.builder()
                .avatar(Objects.requireNonNull(gitUserInfoVO).getAvatar_url())
                .id(gitUserInfoVO.getId())
                .nickname(gitUserInfoVO.getName()).build();
    }

    /**
     * 获取Gitee的Token
     *
     * @param code 第三方code
     * @return {@link TokenDO} Gitee的Token
     */
    private TokenDO getGiteeToken(String code) {
        // 根据code换取accessToken
        MultiValueMap<String, String> giteeData = new LinkedMultiValueMap<>();
        // Gitee的Token请求参数
        giteeData.add(CLIENT_ID, giteeProperties.getClientId());
        giteeData.add(CLIENT_SECRET, giteeProperties.getClientSecret());
        giteeData.add(GRANT_TYPE, giteeProperties.getGrantType());
        giteeData.add(REDIRECT_URI, giteeProperties.getRedirectUrl());
        giteeData.add(CODE, code);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(giteeData, null);
        try {
            TokenDO tokenDO = restTemplate.exchange(giteeProperties.getAccessTokenUrl(),
                    HttpMethod.POST,
                    requestEntity,
                    TokenDO.class).getBody();
            return tokenDO;
        } catch (Exception e) {
            throw new ServiceException("Gitee登录错误");
        }
    }
}
