package org.springcloud.turing.biz.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Date;
import java.util.List;

public class MSConsumer {
    public static void main(String[] args) throws Exception{
        // 创建一个消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("delay-producer-group");
        // 连接namesrv
        consumer.setNamesrvAddr("192.168.43.102:9876");
        // 订阅一个主题  * 标识订阅这个主题中所有的消息  后期会有消息过滤
        consumer.subscribe("delay-topic", "*");
        // 设置一个监听器 (一直监听的， 异步回调方式)
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(msgs.get(0).toString());
                System.out.println("消息内容:" + new String(msgs.get(0).getBody()));
                System.out.println("收到时间："+new Date());
                // 返回值  CONSUME_SUCCESS成功，消息会从mq出队
                // RECONSUME_LATER（报错/null） 失败 消息会重新回到队列 过一会重新投递出来 给当前消费者或者其他消费者消费的
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动
        consumer.start();
        // 挂起当前的jvm
        System.in.read();
    }
}