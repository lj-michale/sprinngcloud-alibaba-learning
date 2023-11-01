package org.springcloud.turing.biz.mq.produce;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springcloud.turing.biz.mq.domain.MessageWrapper;
import org.springcloud.turing.biz.mq.event.SendMailAuthResultEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.springcloud.turing.biz.common.constant.RocketMQConstant.PAY_GLOBAL_TOPIC_KEY;
import static org.springcloud.turing.biz.common.constant.RocketMQConstant.REFUND_RESULT_CALLBACK_TAG_KEY;

/**
 * @descri 邮箱认证消息produce
 *
 * @author lj.michale
 * @date 2023-10-23
 */
@Slf4j
@Component
public class SendMailAuthSendProduce extends AbstractCommonSendProduceTemplate<SendMailAuthResultEvent> {

    private final ConfigurableEnvironment environment;

    public SendMailAuthSendProduce(@Autowired RocketMQTemplate rocketMQTemplate,
                                   @Autowired ConfigurableEnvironment environment) {
        super(rocketMQTemplate);
        this.environment = environment;
    }

    @Override
    protected BaseSendExtendDTO buildBaseSendExtendParam(SendMailAuthResultEvent messageSendEvent) {
        return BaseSendExtendDTO.builder()
                .eventName("发送用户邮箱验证码")
                .keys(messageSendEvent.getEmail())
                .topic(environment.resolvePlaceholders(PAY_GLOBAL_TOPIC_KEY))
                .tag(environment.resolvePlaceholders(REFUND_RESULT_CALLBACK_TAG_KEY))
                .sentTimeout(2000L)
                .build();
    }

    @Override
    protected Message<?> buildMessage(SendMailAuthResultEvent messageSendEvent, BaseSendExtendDTO requestParam) {
        String keys = StrUtil.isEmpty(requestParam.getKeys()) ? UUID.randomUUID().toString() : requestParam.getKeys();

        return MessageBuilder
                .withPayload(new MessageWrapper(requestParam.getKeys(), messageSendEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, requestParam.getTag())
                .build();
    }
}
