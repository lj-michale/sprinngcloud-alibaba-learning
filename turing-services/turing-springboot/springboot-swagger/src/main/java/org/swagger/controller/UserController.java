package org.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.swagger.dao.model.User;
import org.swagger.dao.model.UserSchema;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2023/12/22 14:22
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {


    @Operation(summary = "创建用户",description = "根据姓名创建用户")
    @GetMapping("/create")
    public ResponseEntity<String> create(String name){
        return ResponseEntity.ok(name);
    }

    @Operation(summary = "创建用户-createOne",description = "根据姓名创建用户1")
    @PostMapping("/createOne")
    public ResponseEntity<User> createOne(@RequestBody User user){
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "创建用户1",description = "根据姓名创建用户1")
    @PostMapping("/createOne1")
    public ResponseEntity<User> createOne1(@ParameterObject User user){
        return ResponseEntity.ok(user);
    }



    @Operation(summary = "创建用户-Schema",description = "根据姓名创建用户1")
    @PostMapping("/createOneSchema")
    public ResponseEntity<UserSchema> createOneSchema(@RequestBody UserSchema user){
        return ResponseEntity.ok(user);
    }


    @Operation(summary = "body请求")
    @Parameter(name = "deviceId",description = "设备id",in = ParameterIn.PATH)
    @PostMapping("/{deviceId}/body")
    public ResponseEntity<UserSchema> bodyRequest(@PathVariable("deviceId") String deviceId, @RequestBody Object object){
        System.out.println("deviceId:"+deviceId);
        System.out.println("body:"+object.toString());
        return ResponseEntity.ok(new UserSchema());
    }

    @Operation(summary = "body请求1")
    @Parameter(name = "deviceId",description = "设备id",in = ParameterIn.PATH)
    @PostMapping("/{deviceId}/body1")
    public ResponseEntity<UserSchema> bodyRequest1(@PathVariable("deviceId") String deviceId, @RequestBody UserSchema object){
        System.out.println("deviceId:"+deviceId);
        return ResponseEntity.ok(object);
    }

    @Operation(summary = "json参数查询")
    @GetMapping(value = "/getRequest",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSchema> getRequest(UserSchema userSchema,@RequestParam("cade")String cade){
        return ResponseEntity.ok(userSchema);
    }
    @Operation(summary = "json参数查询1")
    @PostMapping(value = "/getRequest1",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSchema> getRequest1(@RequestBody UserSchema userSchema,@RequestParam("cade")String cade){
        return ResponseEntity.ok(userSchema);
    }
}