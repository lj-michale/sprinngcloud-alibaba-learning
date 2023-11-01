/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springcloud.turing.biz.mq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springcloud.turing.biz.common.constant.OrderRocketMQConstant;
import org.springcloud.turing.biz.mq.domain.MessageWrapper;
import org.springcloud.turing.biz.mq.event.SendMailAuthResultEvent;
import org.springcloud.turing.framework.starter.idempotent.annotation.Idempotent;
import org.springcloud.turing.framework.starter.idempotent.enums.IdempotentSceneEnum;
import org.springcloud.turing.framework.starter.idempotent.enums.IdempotentTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付结果回调订单消费者
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RocketMQMessageListener(
        topic = OrderRocketMQConstant.PAY_GLOBAL_TOPIC_KEY,
        selectorExpression = OrderRocketMQConstant.REFUND_RESULT_CALLBACK_TAG_KEY,
        consumerGroup = OrderRocketMQConstant.PAY_RESULT_CALLBACK_ORDER_CG_KEY
)
public class PayResultCallbackOrderConsumer implements RocketMQListener<MessageWrapper<SendMailAuthResultEvent>> {

//    private final OrderService orderService;

    @Idempotent(
            uniqueKeyPrefix = "index12306-order:pay_result_callback:",
            key = "#message.getKeys()+'_'+#message.hashCode()",
            type = IdempotentTypeEnum.SPEL,
            scene = IdempotentSceneEnum.MQ,
            keyTimeout = 7200L
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void onMessage(MessageWrapper<SendMailAuthResultEvent> message) {
        SendMailAuthResultEvent sendMailAuthResultEvent = message.getMessage();
//        OrderStatusReversalDTO orderStatusReversalDTO = OrderStatusReversalDTO.builder()
//                .orderSn(payResultCallbackOrderEvent.getOrderSn())
//                .orderStatus(OrderStatusEnum.ALREADY_PAID.getStatus())
//                .orderItemStatus(OrderItemStatusEnum.ALREADY_PAID.getStatus())
//                .build();
//        orderService.statusReversal(orderStatusReversalDTO);
//        orderService.payCallbackOrder(payResultCallbackOrderEvent);
    }
}
