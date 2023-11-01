package org.springcloud.turing.biz.dao.entity;

import lombok.Data;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
//@ApiModel(description = "Token")
public class TokenDO {
    /**
     * 访问令牌
     */
//    @ApiModelProperty(value = "访问令牌")
    private String access_token;
}
