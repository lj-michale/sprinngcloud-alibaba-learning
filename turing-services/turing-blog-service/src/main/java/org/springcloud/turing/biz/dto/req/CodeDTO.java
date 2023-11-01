package org.springcloud.turing.biz.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
//@ApiModel(description = "Code信息")
public class CodeDTO {

    /**
     * code
     */
    @NotBlank(message = "code不能为空")
//    @ApiModelProperty(value = "code")
    private String code;
}