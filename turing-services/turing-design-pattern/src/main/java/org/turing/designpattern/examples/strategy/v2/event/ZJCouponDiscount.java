package org.turing.designpattern.examples.strategy.v2.event;

import org.turing.designpattern.examples.strategy.v2.ICouponDiscount;

import java.math.BigDecimal;


/**
 * @descri: 直减
 *
 * @author: lj.michale
 * @date: 2024/1/4 15:22
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}