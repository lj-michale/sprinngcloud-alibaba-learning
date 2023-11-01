package org.springcloud.turing.biz.service.impl.user;

import com.alibaba.fastjson2.JSON;
import org.springcloud.turing.biz.common.enums.LoginTypeEnum;
import org.springcloud.turing.biz.config.QqProperties;
import org.springcloud.turing.biz.dao.entity.QqUserInfoDO;
import org.springcloud.turing.biz.dao.entity.SocialTokenDO;
import org.springcloud.turing.biz.dao.entity.SocialUserInfoDO;
import org.springcloud.turing.biz.dao.entity.TokenDO;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.biz.dto.resp.QqLoginDTO;
import org.springcloud.turing.framework.starter.convention.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springcloud.turing.biz.common.constant.SocialLoginConstant.*;

/**
 * @descri Qq登录策略
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Service("qqLoginStrategyImpl")
public class QqLoginStrategyImpl extends AbstractLoginStrategyImpl {

    @Autowired
    private QqProperties qqProperties;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public SocialTokenDO getSocialToken(CodeDTO codeDTO) {
        // 获取Qq的Token
        TokenDO qqToken = getQqToken(codeDTO.getCode());
        // 获取用户OpenId
        String userOpenId = getUserOpenId(qqToken.getAccess_token());
        // 返回token信息
        return SocialTokenDO.builder()
                .openId(userOpenId)
                .accessToken(qqToken.getAccess_token())
                .loginType(LoginTypeEnum.QQ.getLoginType())
                .build();
    }

    @Override
    public SocialUserInfoDO getSocialUserInfo(SocialTokenDO socialToken) {
        // 定义请求参数
        Map<String, String> formData = new HashMap<>(3);
        formData.put(QQ_OPEN_ID, socialToken.getOpenId());
        formData.put(ACCESS_TOKEN, socialToken.getAccessToken());
        formData.put(OAUTH_CONSUMER_KEY, qqProperties.getAppId());
        // 获取QQ返回的用户信息
        QqUserInfoDO qqUserInfo = JSON.parseObject(restTemplate.getForObject(qqProperties.getUserInfoUrl(), String.class, formData), QqUserInfoDO.class);
        // 返回用户信息
        return SocialUserInfoDO.builder()
                .id(socialToken.getOpenId())
                .nickname(Objects.requireNonNull(qqUserInfo).getNickname())
                .avatar(qqUserInfo.getFigureurl_qq_1())
                .build();
    }

    /**
     * 获取QQ的Token
     *
     * @param code 第三方code
     * @return {@link TokenDO} QQ的Token
     */
    private TokenDO getQqToken(String code) {
        // 根据code换取accessToken
        Map<String, String> qqData = new HashMap<>(5);
        // Gitee的Token请求参数
        qqData.put(GRANT_TYPE, qqProperties.getGrantType());
        qqData.put(CLIENT_ID, qqProperties.getAppId());
        qqData.put(CLIENT_SECRET, qqProperties.getAppKey());
        qqData.put(CODE, code);
        qqData.put(REDIRECT_URI, qqProperties.getRedirectUrl());
        try {
            return restTemplate.getForObject(qqProperties.getAccessTokenUrl(), TokenDO.class, qqData);
        } catch (Exception e) {
            throw new ServiceException("QQ登录错误");
        }
    }

    /**
     * 获取用户的OpenId
     *
     * @return 用户的OpenId
     */
    private String getUserOpenId(String accessToken) {
        Map<String, String> dataMap = new HashMap<>(1);
        // 请求参数
        dataMap.put(ACCESS_TOKEN, accessToken);
        // 返回用户OpenId
        QqLoginDTO qqLoginDTO = restTemplate.getForObject(qqProperties.getUserOpenIdUrl(), QqLoginDTO.class, dataMap);
        return qqLoginDTO.getOpenid();
    }
}