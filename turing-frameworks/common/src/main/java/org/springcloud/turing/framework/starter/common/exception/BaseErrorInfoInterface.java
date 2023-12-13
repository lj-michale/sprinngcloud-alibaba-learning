package org.springcloud.turing.framework.starter.common.exception;

/**
 * @descri 此接口用于返回码枚举使用
 *
 * @author lj.michale
 * @date 2022-08-16
 */
public interface BaseErrorInfoInterface {

    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();

}
