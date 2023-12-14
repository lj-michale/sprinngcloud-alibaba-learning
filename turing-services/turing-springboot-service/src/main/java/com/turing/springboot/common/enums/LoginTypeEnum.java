package com.turing.springboot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录方式枚举
 *
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    /**
     * 邮箱
     */
    EMAIL(1, "邮箱登录", ""),

    /**
     * QQ
     */
    QQ(2, "QQ登录", "qqLoginStrategyImpl"),

    /**
     * Gitee
     */
    GITEE(3, "Gitee登录", "giteeLoginStrategyImpl"),

    /**
     * Github
     */
    GITHUB(4, "Github登录", "githubLoginStrategyImpl"),

    /**
     * 微信
     */
    WECHAT(5,"微信登录","weichatLoginStrategyImpl");

    /**
     * 登录方式
     */
    private final Integer loginType;

    /**
     * 描述
     */
    private final String description;

    /**
     * 策略
     */
    private final String strategy;
}