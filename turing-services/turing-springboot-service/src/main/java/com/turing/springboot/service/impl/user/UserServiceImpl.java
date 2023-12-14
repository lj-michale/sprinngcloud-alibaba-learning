package com.turing.springboot.service.impl.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.turing.springboot.common.urils.SecurityUtils;
import com.turing.springboot.dao.entity.UserDO;
import com.turing.springboot.dao.mapper.UserMapper;
import com.turing.springboot.dto.req.UserDeletionReqDTO;
import com.turing.springboot.dto.req.UserLoginReqDTO;
import com.turing.springboot.dto.req.UserRegisterReqDTO;
import com.turing.springboot.dto.resp.UserLoginRespDTO;
import com.turing.springboot.dto.resp.UserRegisterRespDTO;
import com.turing.springboot.service.RedisService;
import com.turing.springboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.turing.springboot.common.constant.RedisConstant.CODE_EXPIRE_TIME;
import static com.turing.springboot.common.constant.RedisConstant.CODE_KEY;
import static com.turing.springboot.common.urils.CommonUtils.checkEmail;

/**
 * @descri 用户业务接口实现类
 *
 * @author lj.michale
 * @date 2023-10-23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public String login(UserLoginReqDTO requestParam) {
        UserDO user = userMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getId)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, SecurityUtils.sha256Encrypt(requestParam.getPassword())));
        log.info("注册用户信息查询:{}", JSON.toJSONString(user));
        Assert.notNull(user, "用户不存在或密码错误");
        StpUtil.checkDisable(user.getId());
        StpUtil.login(user.getId());

        log.info("用户登录Token：{}", StpUtil.getTokenValue());
        return StpUtil.getTokenValue();
    }

    @Override
    public UserLoginRespDTO checkLogin(String accessToken) {

        return null;
    }

    @Override
    public void sendCode(String username) {
        Assert.isTrue(checkEmail(username), "请输入正确的邮箱！");
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        String code = randomGenerator.generate();

        redisService.setObject(CODE_KEY + username, code, CODE_EXPIRE_TIME, TimeUnit.MINUTES);
    }

    @Override
    public void logout(String accessToken) {

    }

    @Override
    public Boolean hasUsername(String username) {
        return null;
    }

    @Override
    public Boolean register(UserRegisterReqDTO requestParam) {
        verifyCode(requestParam.getUsername(), requestParam.getCode());
        UserDO user = userMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getUsername)
                .eq(UserDO::getUsername, requestParam.getUsername()));
        Assert.isNull(user, "邮箱已注册！");
        // 添加用户
        UserDO newUser = UserDO.builder()
                .username(requestParam.getUsername())
                .email(requestParam.getUsername())
                .password(SecurityUtils.sha256Encrypt(requestParam.getPassword()))
                .build();
        userMapper.insert(newUser);

        return true;
    }

    @Override
    public void deletion(UserDeletionReqDTO requestParam) {

    }


    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code     验证码
     */
    public void verifyCode(String username, String code) {
        String sysCode = redisService.getObject(CODE_KEY + username);
        Assert.notBlank(sysCode, "验证码未发送或已过期！");
        Assert.isTrue(sysCode.equals(code), "验证码错误，请重新输入！");
    }

}
