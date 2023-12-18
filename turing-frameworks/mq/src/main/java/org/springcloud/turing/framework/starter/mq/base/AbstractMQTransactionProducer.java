package org.springcloud.turing.framework.starter.mq.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springcloud.turing.framework.starter.mq.MQException;

/**
 * @descri: RocketMQ的事务生产者的抽象基类
 *
 * @author: lj.michale
 * @date: 2023/12/18 11:34
 */
@Slf4j
public abstract class AbstractMQTransactionProducer implements TransactionListener {

    private TransactionMQProducer transactionProducer;

    public void setProducer(TransactionMQProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    public SendResult sendMessageInTransaction(Message msg, Object arg) throws MQException {
        try {
            SendResult sendResult = transactionProducer.sendMessageInTransaction(msg, arg);
            if(sendResult.getSendStatus() != SendStatus.SEND_OK) {
                log.error("事务消息发送失败，topic : {}, msgObj {}", msg.getTopic(), msg);
                throw new MQException("事务消息发送失败，topic :" + msg.getTopic() + ", status :" + sendResult.getSendStatus());
            }
            log.info("发送事务消息成功，事务id: {}", msg.getTransactionId());
            return sendResult;
        } catch (Exception e) {
            log.error("事务消息发送失败，topic : {}, msgObj {}", msg.getTopic(), msg);
            throw new MQException("事务消息发送失败，topic :" + msg.getTopic() + ",e:" + e.getMessage());
        }
    }


}