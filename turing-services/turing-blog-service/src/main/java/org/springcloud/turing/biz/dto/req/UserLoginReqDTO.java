package org.springcloud.turing.biz.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @descri 用户登录请求参数
 *
 * @author lj.michale
 * @date 2023-10-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReqDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
//    @ApiModelProperty(value = "用户名")
    private String usernameOrMailOrPhone;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码不能少于6位")
//    @ApiModelProperty(value = "用户密码")
    private String password;
}

