package org.turing.designpattern.composite;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.composite.v1.EngineController;

import java.util.HashMap;
import java.util.Map;


/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/3 15:52
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(org.turing.designpattern.factory.ApiTest.class);

    @Test
    public void test_EngineController() {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        logger.info("测试结果：{}", process);
    }


}
