package org.turing.designpattern.bridge;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.bridge.v1.PayController;
import org.turing.designpattern.examples.bridge.v2.channel.Pay;
import org.turing.designpattern.examples.bridge.v2.channel.WxPay;
import org.turing.designpattern.examples.bridge.v2.channel.ZfbPay;
import org.turing.designpattern.examples.bridge.v2.mode.PayFaceMode;
import org.turing.designpattern.examples.bridge.v2.mode.PayFingerprintMode;


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
     *
     * 从测试结果看已经满足了我们的不同支付类型和支付模式的组合，但是这样的代码在后面的维护以及扩展都会变得非常复杂。
     */
    @Test
    public void test_pay() {
        PayController pay = new PayController();
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111","100000109894",new BigDecimal(100), 2, 3);
    }

    @Test
    public void test_pay2() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }


}