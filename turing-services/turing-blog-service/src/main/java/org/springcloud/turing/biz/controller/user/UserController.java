package org.springcloud.turing.biz.controller.user;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.biz.dto.req.UserLoginReqDTO;
import org.springcloud.turing.biz.dto.req.UserRegisterReqDTO;
import org.springcloud.turing.biz.dto.resp.UserLoginRespDTO;

import org.springcloud.turing.biz.service.user.UserService;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.log.annotation.ILog;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @descri  http://192.168.43.102:9011/swagger-ui.html
 *
 * @author lj.michale
 * @date 2023-10-23
 */
@Slf4j
@RestController
@RequiredArgsConstructor
//@Api(value = "UserController", tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录 http://localhost:9011/api/blog-server/user/login?usernameOrMailOrPhone=lj.michale&password=Turing@2023
     *
     * @param userLoginReqDTO 登录参数
     * @return {@link String} Token
     */
//    @ApiOperation(value = "用户登录")
    @ILog
    @PostMapping("/api/blog-server/user/login")
    public Result<String> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Results.success(userService.login(userLoginReqDTO));
    }

    /**
     * 用户退出
     */
    @SaCheckLogin
//    @ApiOperation(value = "用户退出")
    @GetMapping("/logout")
    public Result<?> logout() {
        StpUtil.logout();
        return Results.success();
    }

    /**
     * 通过 Token 检查用户是否登录
     */
    @ILog
    @GetMapping("/api/blog-server/user/check-login")
    public Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken) {
        UserLoginRespDTO result = userService.checkLogin(accessToken);

        return Results.success(result);
    }

    /**
     * 发送邮箱验证码
     *
     * @return {@link Result<>}
     */
    @ILog
    @GetMapping("/api/blog-server/user/code")
    public Result<?> sendCode(String username) {
        userService.sendCode(username);

        return Results.success();
    }

    /**
     * 用户邮箱注册
     *
     * @param register 注册信息
     * @return {@link Result<>}
     */
    @ILog
//    @ApiOperation(value = "用户邮箱注册")
    @PostMapping("/api/blog-server/user/register")
    public Result<?> register(@Validated @RequestBody UserRegisterReqDTO register) {
        userService.register(register);

        return Results.success();
    }

    /**
     * Gitee登录
     *
     * @param data 第三方code
     * @return {@link Result<String>} Token
     */
    @ILog
//    @ApiOperation(value = "Gitee登录")
    @PostMapping("/api/blog-server/user/oauth/gitee")
    public Result<String> giteeLogin(@RequestBody CodeDTO data) {
        return Results.success(userService.giteeLogin(data));
    }

    /**
     * QQ登录
     *
     * @param data 第三方code
     * @return {@link Result<String>} Token
     */
//    @ApiOperation(value = "QQ登录")
    @PostMapping("/oauth/qq")
    public Result<String> qqLogin(@Validated @RequestBody CodeDTO data) {
        return Results.success(userService.qqLogin(data));
    }

}
