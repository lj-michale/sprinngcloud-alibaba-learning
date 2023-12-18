package org.springcloud.turing.framework.starter.mq.annotation;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;

/**
 * @descri: RocketMQ生产者自动装配注解
 *
 * @author: lj.michale
 * @date: 2023/12/18 11:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MQProducer {
}