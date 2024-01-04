package org.turing.designpattern.examples.strategy.v2.event;

import org.turing.designpattern.examples.strategy.v2.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @descri: 折扣
 *
 * @author: lj.michale
 * @date: 2024/1/4 15:23
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {


    /**
     * 折扣计算
     * 1. 使用商品价格乘以折扣比例，为最后支付金额
     * 2. 保留两位小数
     * 3. 最低支付金额1元
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}