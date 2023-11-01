package org.springcloud.turing.biz.dao.entity;

import lombok.Data;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
//@ApiModel(description = "Git用户信息")
public class GitUserInfoDO {

    /**
     * 用户id
     */
//    @ApiModelProperty(value = "用户id")
    private String id;

    /**
     * 头像
     */
//    @ApiModelProperty(value = "头像")
    private String avatar_url;

    /**
     * 昵称
     */
//    @ApiModelProperty(value = "昵称")
    private String name;

    /**
     * 登录
     */
//    @ApiModelProperty(value = "登录")
    private String login;
}
