package org.turing.designpattern.bridge;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.bridge.v1.PayController;
import org.turing.designpattern.service.factory.v1.PrizeService;
import org.turing.designpattern.service.factory.v2.StoreFactory;
import org.turing.designpattern.service.factory.v2.store.ICommodity;
import turing.designpattern.dto.req.factory.AwardReq;
import turing.designpattern.examples.factory.AwardRes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/3 15:52
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * @descri: 用一坨坨代码实现: 分别测试了两种不同的支付类型和支付模式；微信人脸支付、支付宝指纹支付
     */
    @Test
    public void test_pay() {
        PayController pay = new PayController();
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111","100000109894",new BigDecimal(100), 2, 3);
    }


}