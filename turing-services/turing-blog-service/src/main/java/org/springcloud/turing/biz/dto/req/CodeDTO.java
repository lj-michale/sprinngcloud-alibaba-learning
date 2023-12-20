package org.springcloud.turing.biz.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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