package com.turing.springboot.service.user;

import com.turing.springboot.dto.req.UserDeletionReqDTO;
import com.turing.springboot.dto.req.UserLoginReqDTO;
import com.turing.springboot.dto.req.UserRegisterReqDTO;
import com.turing.springboot.dto.resp.UserLoginRespDTO;

public interface UserService {

    /**
     * 用户登录
     *
     * @param requestParam 用户登录入参
     * @return 用户登录返回结果
     */
    String login(UserLoginReqDTO requestParam);

    /**
     * 通过 Token 检查用户是否登录
     *
     * @param accessToken 用户登录 Token 凭证
     * @return 用户是否登录返回结果
     */
    UserLoginRespDTO checkLogin(String accessToken);

    /**
     * 发送验证码
     *
     * @param username 用户名
     */
    void sendCode(String username);

    /**
     * 用户退出登录
     *
     * @param accessToken 用户登录 Token 凭证
     */
    void logout(String accessToken);

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return 用户名是否存在返回结果
     */
    Boolean hasUsername(String username);

    /**
     * 用户注册
     *
     * @param requestParam 用户注册入参
     * @return 用户注册返回结果
     */
    Boolean register(UserRegisterReqDTO requestParam);


    /**
     * 注销用户
     *
     * @param requestParam 注销用户入参
     */
    void deletion(UserDeletionReqDTO requestParam);

}
