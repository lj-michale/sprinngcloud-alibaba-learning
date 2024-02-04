package org.turing.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.turing.rocketmq.Person;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/2/4 11:22
 */
@Component
@RocketMQMessageListener(consumerGroup = "${rocketmq.producer.groupName}", topic = "PERSON_ADD")
public class PersonMqListener implements RocketMQListener<Person> {
    @Override
    public void onMessage(Person person) {
        System.out.println("接收到消息，开始消费..name:" + person.getName() + ",age:" + person.getAge());
    }
}