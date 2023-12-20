package org.springcloud.turing.biz.service.impl.user;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springcloud.turing.biz.dao.entity.SocialTokenDO;
import org.springcloud.turing.biz.dao.entity.SocialUserInfoDO;
import org.springcloud.turing.biz.dao.entity.UserDO;
import org.springcloud.turing.biz.dao.entity.UserRoleDO;
import org.springcloud.turing.biz.dao.mapper.UserMapper;
import org.springcloud.turing.biz.dao.mapper.UserRoleMapper;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.biz.service.user.SocialLoginStrategy;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springcloud.turing.biz.common.enums.RoleEnum.USER;

/**
 * @descri 抽象登录模板
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Service
public abstract class AbstractLoginStrategyImpl implements SocialLoginStrategy {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public String login(CodeDTO data) {
        UserDO user;
        // 获取token
        SocialTokenDO socialToken = getSocialToken(data);
        // 获取用户信息
        SocialUserInfoDO socialUserInfoVO = getSocialUserInfo(socialToken);
        // 判断是否已注册
        UserDO existUser = userMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getId)
                .eq(UserDO::getUsername, socialUserInfoVO.getId())
                .eq(UserDO::getLoginType, socialToken.getLoginType()));
        // 用户未登录过
        if (Objects.isNull(existUser)) {
            user = saveLoginUser(socialToken, socialUserInfoVO);
        } else {
            user = existUser;
        }
        // 校验指定账号是否已被封禁，如果被封禁则抛出异常 `DisableServiceException`
        StpUtil.checkDisable(user.getId());
        // 通过校验后，再进行登录
        StpUtil.login(user.getId());

        return StpUtil.getTokenValue();
    }

    /**
     * 获取第三方Token
     *
     * @param data data
     * @return {@link SocialTokenDO} 第三方token
     */
    public abstract SocialTokenDO getSocialToken(CodeDTO data);


    /**
     * 获取第三方用户信息
     *
     * @param socialToken 第三方token
     * @return {@link SocialUserInfoDO} 第三方用户信息
     */
    public abstract SocialUserInfoDO getSocialUserInfo(SocialTokenDO socialToken);


    /**
     * 新增用户账号
     *
     * @param socialToken 第三方Token
     * @return {@link UserDO} 登录用户身份权限
     */
    private UserDO saveLoginUser(SocialTokenDO socialToken,
                                 SocialUserInfoDO socialUserInfoVO) {
        // 新增用户信息
        UserDO newUser = UserDO.builder()
                .avatar(socialUserInfoVO.getAvatar())
                .nickname(socialUserInfoVO.getNickname())
                .username(socialUserInfoVO.getId())
                .password(socialToken.getAccessToken())
                .loginType(socialToken.getLoginType())
                .build();
        userMapper.insert(newUser);
        // 新增用户角色
        UserRoleDO userRole = UserRoleDO.builder()
                .userId(newUser.getId())
                .roleId(USER.getRoleId())
                .build();
        userRoleMapper.insert(userRole);

        return newUser;
    }


}
