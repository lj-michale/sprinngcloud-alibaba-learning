package org.springcloud.turing.biz.mq.rocketmq;

import jakarta.annotation.Resource;
import org.junit.After;
import org.junit.Test;
import org.springcloud.turing.framework.starter.mq.base.AbstractMQPushConsumer;
import org.springcloud.turing.framework.starter.mq.config.MQConsumerAutoConfiguration;
import org.springcloud.turing.framework.starter.mq.annotation.MQConsumer;

import org.springcloud.turing.framework.starter.mq.base.MessageExtConst;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MQConsumerAutoConfigurationTest {

    @Resource
    public Environment environment;

    private AnnotationConfigApplicationContext context;

    private void prepareApplicationContext() {
        this.context = new AnnotationConfigApplicationContext();
        environment.getProperty("spring.rocketmq.name-server-address:192.168.43.102:9876");
        this.context.register(TestConsumer.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    private void prepareApplicationContextCMOrderly() {
        this.context = new AnnotationConfigApplicationContext();
        environment.getProperty("spring.rocketmq.name-server-address:192.168.43.102:9876");
        this.context.register(TestConsumerOrderly.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    private void prepareApplicationContextCMError() {
        this.context = new AnnotationConfigApplicationContext();
        environment.getProperty("spring.rocketmq.name-server-address:192.168.43.102:9876");
        this.context.register(TestConsumerErrorCM.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    private void prepareApplicationContextMissingNS() {
        this.context = new AnnotationConfigApplicationContext();
        this.context.register(TestConsumer.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    private void prepareApplicationContextMissingParent() {
        this.context = new AnnotationConfigApplicationContext();
        environment.getProperty("spring.rocketmq.name-server-address:192.168.43.102:9876");
        this.context.register(TestConsumerMissingParent.class);
        this.context.register(MQConsumerAutoConfiguration.class);
        this.context.refresh();
    }

    @After
    public void close() {
        this.context.close();
    }

    @Test
    public void testConsumerConfiguration() throws Exception {
        prepareApplicationContext();
        TestConsumer testConsumer = context.getBean(TestConsumer.class);
        assertNotNull(testConsumer.getConsumer());
        assertEquals(testConsumer.getConsumer().getConsumerGroup(), "test_consumer_group");
        assertEquals(testConsumer.getConsumer().getNamesrvAddr(), "192.168.43.102:9876");
    }

    @Test(expected = RuntimeException.class)
    public void testConsumerMissingNS() {
        prepareApplicationContextMissingNS();
    }

    @Test(expected = RuntimeException.class)
    public void testConsumerMissingParent() {
        prepareApplicationContextMissingParent();
    }

    @Test
    public void testConsumerModeOrderly() {
        prepareApplicationContextCMOrderly();
        TestConsumerOrderly testConsumer = context.getBean(TestConsumerOrderly.class);
        assertNotNull(testConsumer.getConsumer());
        assertEquals(testConsumer.getConsumer().getConsumerGroup(), "test_consumer_group");
        assertEquals(testConsumer.getConsumer().getNamesrvAddr(), "192.168.43.102:9876");
    }

    @Test(expected = RuntimeException.class)
    public void testConsumerModeERROR() {
        prepareApplicationContextCMError();
    }

    @Component
    @MQConsumer(consumerGroup = "test_consumer_group", topic = "test_topic")
    static class TestConsumer extends AbstractMQPushConsumer<String> {
        @Override
        public boolean process(String message, Map<String, Object> extMap) {
            return true;
        }
    }

    @Component
    @MQConsumer(consumerGroup = "test_consumer_group", topic = "test_topic", consumeMode = MessageExtConst.CONSUME_MODE_ORDERLY)
    static class TestConsumerOrderly extends AbstractMQPushConsumer<String> {
        @Override
        public boolean process(String message, Map<String, Object> extMap) {
            return true;
        }
    }

    @Component
    @MQConsumer(consumerGroup = "test_consumer_group", topic = "test_topic", consumeMode = "TYPE_MESSAGE_MODE")
    static class TestConsumerErrorCM extends AbstractMQPushConsumer<String> {
        @Override
        public boolean process(String message, Map<String, Object> extMap) {
            return true;
        }
    }

    @Component
    @MQConsumer(consumerGroup = "test_consumer_group", topic = "test_topic")
    static class TestConsumerMissingParent{
    }

}