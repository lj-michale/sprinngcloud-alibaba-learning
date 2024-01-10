package org.turing.designpattern.template;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.template.Bouilli;
import org.turing.designpattern.examples.template.DodishTemplate;
import org.turing.designpattern.examples.template.EggsWithTomato;
import org.turing.designpattern.examples.template.demo2.NetMall;
import org.turing.designpattern.examples.template.demo2.impl.JDNetMall;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/10 10:29
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testApp() {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
    }

    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }


}