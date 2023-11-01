package org.springcloud.turing.biz.dto.resp;

import lombok.Data;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
//@ApiModel(description = "QQ登录DTO")
public class QqLoginDTO {

    /**
     * openId
     */
//    @ApiModelProperty(value = "openId")
    private String openid;

    /**
     * clientId
     */
//    @ApiModelProperty(value = "clientId")
    private String client_id;
}