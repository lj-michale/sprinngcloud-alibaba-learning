package org.springcloud.turing.biz.mq.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

public class DelayProducer {
    public static void main(String[] args) throws Exception{
        // 创建默认的生产者
        DefaultMQProducer producer = new DefaultMQProducer("delay-producer-group");
        // 设置nameServer地址
        producer.setNamesrvAddr("192.168.43.102:9876");
        // 启动实例
        producer.start();
        Message msg = new Message("delay-topic", ("延迟消息").getBytes());
        // 给这个消息设定一个延迟等级
        // messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        msg.setDelayTimeLevel(3);
        // 发送单向消息
        producer.send(msg);
        // 打印时间
        System.out.println(new Date());
        // 关闭实例
        producer.shutdown();
    }
}