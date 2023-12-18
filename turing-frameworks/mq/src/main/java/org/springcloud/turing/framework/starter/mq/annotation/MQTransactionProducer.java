package org.springcloud.turing.framework.starter.mq.annotation;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;

/**
 * @descri: RocketMQ事务消息生产者
 *
 * @author: lj.michale
 * @date: 2023/12/18 11:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MQTransactionProducer {

    /**
     * *重要* 事务的反查是基于同一个producerGroup为维度
     */
    String producerGroup();
}