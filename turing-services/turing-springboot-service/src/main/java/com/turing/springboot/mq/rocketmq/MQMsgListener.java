//package com.turing.springboot.mq.rocketmq;
//
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RocketMQMessageListener(topic = "delayTopic",consumerGroup="boot-mq-group-consumer")
//public class MQMsgListener implements RocketMQListener<MessageExt> {
//
//    @Override
//    public void onMessage(MessageExt message) {
//        String msgId = message.getMsgId();
//        String msg = new String(message.getBody());
//        System.out.println("消息id："+msgId+"消息内容："+msg);
//    }
//
//}
