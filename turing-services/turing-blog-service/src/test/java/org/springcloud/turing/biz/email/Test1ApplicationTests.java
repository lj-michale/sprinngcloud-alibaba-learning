package org.springcloud.turing.biz.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-26
 */
@SpringBootTest
class Test1ApplicationTests {

    @Resource
    private JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("dataops_tony2016@163.com");
        mailMessage.setTo("2715053558@qq.com");
        mailMessage.setText("你好 hello world");
        mailMessage.setSubject("测试Spring邮箱服务");
        mailSender.send(mailMessage);
        System.out.println("====完成发送！====");
    }

}
