package com.turing.springboot.mq.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/18 16:04
 */
@Component
@RocketMQMessageListener(consumerGroup = "group1", topic = "topic1")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("Received message : " + message);
    }
}
