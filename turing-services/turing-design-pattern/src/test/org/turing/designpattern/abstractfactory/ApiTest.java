package org.turing.designpattern.abstractfactory;

import org.junit.jupiter.api.Test;
import org.turing.designpattern.service.abstractfactory.cuisine.CacheService;
import org.turing.designpattern.service.abstractfactory.cuisine.impl.CacheServiceImpl;

public class ApiTest {

    @Test
    public void test_CacheService() {

        CacheService cacheService = (CacheService) new CacheServiceImpl();

        cacheService.set("user_name_01", "小傅哥", 1);
        String val01 = cacheService.get("user_name_01", 1);
        System.out.println("测试结果：" + val01);

    }

}