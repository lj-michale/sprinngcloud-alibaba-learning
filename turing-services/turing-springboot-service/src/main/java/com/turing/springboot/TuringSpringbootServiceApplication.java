package com.turing.springboot;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/14 11:33
 */
@SpringBootApplication
@MapperScan("com.turing.springboot.dao")
@Slf4j
public class TuringSpringbootServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringSpringbootServiceApplication.class, args);
        log.info("启动成功：Sa-Token配置如下:{}", SaManager.getConfig());
    }


}
