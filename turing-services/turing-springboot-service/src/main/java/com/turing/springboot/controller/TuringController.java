package com.turing.springboot.controller;

import com.turing.springboot.dao.entity.UpdateTimeLineVo;
import com.turing.springboot.mq.rocketmq.RocketMQProducer;
import com.turing.springboot.service.UpdateTimeLineServer;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.framework.starter.common.exception.ResultBody;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.log.annotation.ILog;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-08-21
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/turing")
public class TuringController {

    private final String topic = "delay-topic";

    @Resource
    private UpdateTimeLineServer updateTimeLineServer;

    @Resource
    private RocketMQProducer producer;

    @GetMapping("/update/timeline")
    @ResponseBody
    public ResultBody updateTimeLine() {
        log.info("查询sys timeline");
        List<UpdateTimeLineVo> updateTimeLineVos = updateTimeLineServer.getUpdateTimeLines();

//        log.info("系统日志更新信息:{}", JSON.parse(updateTimeLineVos.toString()));
        return ResultBody.success(updateTimeLineVos);
    }

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "Hello SpringBoot";
    }

    @ILog
    @RequestMapping("/sendMessage")
    public Result<String> sendMessage(String message) {
        producer.sendMessage(topic, message);
        return Results.success("消息发送成功");
    }


}
