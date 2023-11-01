package org.springcloud.turing.biz.dao.entity;

import lombok.Data;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
public class QqUserInfoDO {

    /**
     * 用户开放id
     */
    private String openId;

    /**
     * QQ头像
     */
    private String figureurl_qq_1;

    /**
     * 昵称
     */
    private String nickname;
}