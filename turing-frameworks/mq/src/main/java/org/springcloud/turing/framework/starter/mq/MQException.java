package org.springcloud.turing.framework.starter.mq;

/**
 * @descri:  RocketMQ的自定义异常
 *
 * @author: lj.michale
 * @date: 2023/12/18 11:30
 */
public class MQException extends RuntimeException {
    public MQException(String msg) {
        super(msg);
    }
}