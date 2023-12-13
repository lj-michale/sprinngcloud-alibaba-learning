package org.springcloud.turing.framework.starter.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginFailedException  extends RuntimeException {

    private String msg;

}
