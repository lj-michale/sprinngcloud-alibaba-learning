package com.turing.springboot.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
public class CodeDTO {

    /**
     * code
     */
    @NotBlank(message = "code不能为空")
    private String code;
}