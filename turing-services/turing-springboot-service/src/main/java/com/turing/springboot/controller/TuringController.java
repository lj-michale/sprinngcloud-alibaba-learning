package com.turing.springboot.controller;

import com.turing.springboot.entity.UpdateTimeLineVo;
import com.turing.springboot.service.UpdateTimeLineServer;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.framework.starter.common.exception.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-08-21
 */
@RestController
@Slf4j
@RequestMapping("/api/turing")
public class TuringController {

    @Resource
    private UpdateTimeLineServer updateTimeLineServer;

    @GetMapping("/update/timeline")
    public ResultBody updateTimeLine() {
        log.info(" 查询sys timeline ");
        List<UpdateTimeLineVo> updateTimeLineVos = updateTimeLineServer.getUpdateTimeLines();

        return ResultBody.success(updateTimeLineVos);
    }

}
