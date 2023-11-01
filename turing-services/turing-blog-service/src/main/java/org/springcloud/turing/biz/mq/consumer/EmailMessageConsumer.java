package org.springcloud.turing.biz.mq.consumer;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springcloud.turing.biz.common.constant.OrderRocketMQConstant;
import org.springcloud.turing.biz.dto.resp.MailDTO;
import org.springcloud.turing.biz.mq.domain.MessageWrapper;
import org.springcloud.turing.biz.mq.event.SendMailAuthResultEvent;
import org.springcloud.turing.biz.service.EmailService;
import org.springcloud.turing.framework.starter.idempotent.annotation.Idempotent;
import org.springcloud.turing.framework.starter.idempotent.enums.IdempotentSceneEnum;
import org.springcloud.turing.framework.starter.idempotent.enums.IdempotentTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @descri MQ邮件消费者
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RocketMQMessageListener(
        topic = OrderRocketMQConstant.PAY_GLOBAL_TOPIC_KEY,
        selectorExpression = OrderRocketMQConstant.REFUND_RESULT_CALLBACK_TAG_KEY,
        consumerGroup = OrderRocketMQConstant.PAY_RESULT_CALLBACK_ORDER_CG_KEY
)
public class EmailMessageConsumer implements RocketMQListener<MessageWrapper<SendMailAuthResultEvent>> {

    @Autowired
    private EmailService emailService;

//    @Idempotent(uniqueKeyPrefix = "index12306-order:pay_result_callback:",
//                key = "#message.getKeys()+'_'+#message.hashCode()",
//                type = IdempotentTypeEnum.SPEL,
//                scene = IdempotentSceneEnum.MQ,
//                keyTimeout = 7200L)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void onMessage(MessageWrapper<SendMailAuthResultEvent> message) {
        SendMailAuthResultEvent sendMailAuthResultEvent = message.getMessage();
        String toEmail = sendMailAuthResultEvent.getEmail();
        String code = sendMailAuthResultEvent.getCode();
        String subject = sendMailAuthResultEvent.getSubject();
        MailDTO mailDTO = MailDTO.builder()
                .content(code)
                .toEmail(toEmail)
                .subject(subject)
                .build();
        log.info("邮件验证发送内容:{}", JSON.toJSONString(mailDTO));
        emailService.sendSimpleMail(mailDTO);
    }

}
