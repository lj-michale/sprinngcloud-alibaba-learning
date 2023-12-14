package com.turing.springboot.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.turing.springboot.dto.req.UserLoginReqDTO;
import com.turing.springboot.dto.resp.UserLoginRespDTO;
import com.turing.springboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.log.annotation.ILog;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @descri: 用户管理模块
 *
 * @author: lj.michale
 * @date: 2023/12/14 10:47
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/turing/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @ILog
    @PostMapping("/login")
    @ResponseBody
    public Result<String> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Results.success(userService.login(userLoginReqDTO));
    }

    /**
     * 用户退出
     */
    @SaCheckLogin
    @GetMapping("/logout")
    public Result<?> logout() {
        StpUtil.logout();
        return Results.success();
    }

    /**
     * 通过 Token 检查用户是否登录
     */
    @ILog
    @GetMapping("/check-login")
    public Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken) {
        UserLoginRespDTO result = userService.checkLogin(accessToken);

        return Results.success(result);
    }

}
