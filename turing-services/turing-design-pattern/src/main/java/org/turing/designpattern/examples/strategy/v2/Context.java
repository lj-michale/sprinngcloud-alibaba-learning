package org.turing.designpattern.examples.strategy.v2;

import java.math.BigDecimal;


/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/1/4 15:24
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}