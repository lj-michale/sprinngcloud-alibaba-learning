package com.turing.springboot.mq.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RocketMQProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    // 发送消息
    public void sendMessage(String topic, String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
    }

}
