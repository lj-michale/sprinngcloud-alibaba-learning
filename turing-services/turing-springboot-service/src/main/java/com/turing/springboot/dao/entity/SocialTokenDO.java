package com.turing.springboot.dao.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @descri 第三方token
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
@Builder
public class SocialTokenDO {
    /**
     * 开放id
     */
    private String openId;

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 登录类型
     */
    private Integer loginType;

}