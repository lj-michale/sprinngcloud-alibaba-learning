package com.turing.springboot.hander;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2023/12/19 10:14
 */
@Slf4j
@Component
public class XxlJobTest {

    @XxlJob("xxlJobTest")
    public ReturnT<String> xxlJobTest(String date) {
        System.out.println("---------xxlJobTest定时任务执行成功--------");
        return ReturnT.SUCCESS;
    }

}
