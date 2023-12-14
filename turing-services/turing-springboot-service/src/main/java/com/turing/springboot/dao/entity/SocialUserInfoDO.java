package com.turing.springboot.dao.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @descri 第三方账号信息
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
@Builder
//@ApiModel(description = "第三方账号信息")
public class SocialUserInfoDO {
    /**
     * id
     */
//    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 头像
     */
//    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 昵称
     */
//    @ApiModelProperty(value = "昵称")
    private String nickname;
}