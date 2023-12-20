package org.springcloud.turing.biz.service.impl.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springcloud.turing.biz.common.enums.LoginTypeEnum;
import org.springcloud.turing.biz.common.utils.SecurityUtils;
import org.springcloud.turing.biz.dao.entity.UserDO;
import org.springcloud.turing.biz.dao.mapper.UserMapper;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.biz.dto.req.UserDeletionReqDTO;
import org.springcloud.turing.biz.dto.req.UserLoginReqDTO;
import org.springcloud.turing.biz.dto.req.UserRegisterReqDTO;
import org.springcloud.turing.biz.dto.resp.MailDTO;
import org.springcloud.turing.biz.dto.resp.UserLoginRespDTO;
import org.springcloud.turing.biz.dto.resp.UserRegisterRespDTO;
import org.springcloud.turing.biz.mq.event.SendMailAuthResultEvent;
import org.springcloud.turing.biz.mq.produce.SendMailAuthSendProduce;
import org.springcloud.turing.biz.service.RedisService;
import org.springcloud.turing.biz.service.impl.SocialLoginStrategyContext;
import org.springcloud.turing.biz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import static org.springcloud.turing.biz.common.constant.CommonConstant.CAPTCHA;
import static org.springcloud.turing.biz.common.constant.RedisConstant.CODE_EXPIRE_TIME;
import static org.springcloud.turing.biz.common.constant.RedisConstant.CODE_KEY;
import static org.springcloud.turing.biz.common.utils.CommonUtils.checkEmail;

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

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private SocialLoginStrategyContext socialLoginStrategyContext;

    private final SendMailAuthSendProduce sendMailAuthSendProduce;

    @Override
    public String login(UserLoginReqDTO requestParam) {
        UserDO user = userMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getId)
                .eq(UserDO::getUsername, requestParam.getUsernameOrMailOrPhone())
                .eq(UserDO::getPassword, SecurityUtils.sha256Encrypt(requestParam.getPassword())));
        Assert.notNull(user, "用户不存在或密码错误");
        // 校验指定账号是否已被封禁，如果被封禁则抛出异常 `DisableServiceException`
        StpUtil.checkDisable(user.getId());
        // 通过校验后，再进行登录
        StpUtil.login(user.getId());

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
        MailDTO mailDTO = MailDTO.builder()
                .toEmail(username)
                .subject(CAPTCHA)
                .content("您的验证码为 " + code + " 有效期为" + CODE_EXPIRE_TIME + "分钟")
                .build();

        SendMailAuthResultEvent sendMailAuthResultEvent = new SendMailAuthResultEvent();
        sendMailAuthResultEvent.setEmail(mailDTO.getToEmail());
        sendMailAuthResultEvent.setCode(code);
        sendMailAuthResultEvent.setSubject(CAPTCHA);
        sendMailAuthSendProduce.sendMessage(sendMailAuthResultEvent);

        log.info("发送邮箱验证码:{}", code);
        // 验证码存入redis
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
    public UserRegisterRespDTO register(UserRegisterReqDTO requestParam) {
        verifyCode(requestParam.getUsername(), requestParam.getCode());
        UserDO user = userMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .select(UserDO::getUsername)
                .eq(UserDO::getUsername, requestParam.getUsername()));
        Assert.isNull(user, "邮箱已注册！");
        // 添加用户
        UserDO newUser = UserDO.builder()
                .username(requestParam.getUsername())
                .email(requestParam.getUsername())
//                .nickname(requestParam.getNickname() + IdWorker.getId())
//                .avatar(siteConfig.getUserAvatar())
                .password(SecurityUtils.sha256Encrypt(requestParam.getPassword()))
//                .loginType(EMAIL.getLoginType())
//                .delFlag(FALSE)
                .build();
        userMapper.insert(newUser);

        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String giteeLogin(CodeDTO data) {
        return socialLoginStrategyContext.executeLoginStrategy(data, LoginTypeEnum.GITEE);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String qqLogin(CodeDTO data) {
        return socialLoginStrategyContext.executeLoginStrategy(data, LoginTypeEnum.QQ);
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
