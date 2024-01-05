package org.turing.ddd.application.event;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @descri:  Application启动后运行，日志打印微服务关键配置信息(服务名、微服务注册中心地址、配置中心)
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:46
 */
@Component
public class ApplicationRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... strings) {
        Environment environment = applicationContext.getEnvironment();
        try {
            logger.info("spring.application.name : {}", environment.getProperty("spring.application.name"));
            logger.info("eureka.client.service-url.defaultZone : {}", environment.getProperty("eureka.client.service-url.defaultZone"));
            logger.info("spring.cloud.config.discovery.service-id : {}", environment.getProperty("spring.cloud.config.discovery.service-id"));
        } catch (Exception e) {
            logger.warn("Get Properties Exception : {}", e.getMessage());
        }
    }

}