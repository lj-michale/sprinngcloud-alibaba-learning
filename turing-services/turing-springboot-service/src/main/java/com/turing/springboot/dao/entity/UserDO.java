/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.turing.springboot.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog_user")
public class UserDO {

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 国家/地区
     */
    private String region;

    /**
     * 手机号
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 个人介绍
     */
    private String intro;


    /**
     * 登录ip
     */
    @JsonProperty("ipAddress")
    private String ipAddress;

    /**
     * 登录地址
     */
    @JsonProperty("ipSource")
    private String ipSource;

    /**
     * 登录方式 (1邮箱, 2微信, 3Gitee, 4Github)
     */
    @JsonProperty("loginType")
    private Integer loginType;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 注销时间戳
     */
    private Date deletionTime;

}
