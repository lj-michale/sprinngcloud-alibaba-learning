//package org.springcloud.turing.biz.mq;
//
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//
///**
// * @descri
// *
// * @author lj.michale
// * @date 2023-10-24
// */
//public class Producer {
//
//    public static void main(String[] args) throws Exception {
//        DefaultMQProducer producer = new DefaultMQProducer("CID_ONSAPI_OWNER");
//        producer.setNamesrvAddr("192.168.43.102:9876");
//        producer.start();
//        Message msg = new Message("RMQ_SYS_TRANS_HALF_TOPIC", "hello rocketmq".getBytes("UTF-8"));
//        SendResult result = producer.send(msg);
//        System.out.println("返回结果：" + result);
//        producer.shutdown();
//    }
//
//}
