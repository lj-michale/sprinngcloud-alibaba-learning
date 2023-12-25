package org.turing.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.web.bind.annotation.*;
import org.turing.rbac.common.annotation.Auth;
import org.turing.rbac.dto.req.UserReq;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/22 15:01
 */
@RestController
@RequestMapping("/sys/user")
@Auth(id = 1000, name = "user Management Interface")
@Tag(name = "用户管理")
public class SysUserController {

    @PostMapping("/add")
    @Auth(id = 1, name = "add user")
    @Operation(summary = "添加用户",description = "添加用户")
    public Result createUser(@RequestBody UserReq param) {

        return Results.success("succese");
    }

    @DeleteMapping("/delete")
    @Auth(id = 2, name = "delete user")
    @Operation(summary = "删除用户",description = "删除用户")
    public Result deleteUser(@RequestBody Long[] ids) {
        return Results.success("succese");
    }

}
