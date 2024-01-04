package org.turing.designpattern.abstractfactory;

import org.junit.jupiter.api.Test;
import org.turing.designpattern.service.abstractfactory.cuisine.CacheService;
import org.turing.designpattern.service.abstractfactory.cuisine.impl.CacheServiceImpl;
import org.turing.designpattern.service.abstractfactory.v2.factory.JDKProxy;
import org.turing.designpattern.service.abstractfactory.v2.factory.impl.EGMCacheAdapter;
import org.turing.designpattern.service.abstractfactory.v2.factory.impl.IIRCacheAdapter;

public class ApiTest {

    @Test
    public void test_CacheService() {

        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name_01", "小傅哥", 1);
        String val01 = cacheService.get("user_name_01", 1);
        System.out.println("测试结果：" + val01);

    }

    /**
     * @descri: 抽象工厂模式
     *
     */
    @Test
    public void test_CacheService2() throws Exception {

        org.turing.designpattern.service.abstractfactory.v2.CacheService proxy_EGM = JDKProxy.getProxy(org.turing.designpattern.service.abstractfactory.v2.impl.CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        org.turing.designpattern.service.abstractfactory.v2.CacheService proxy_IIR = JDKProxy.getProxy(org.turing.designpattern.service.abstractfactory.v2.impl.CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

    }


}