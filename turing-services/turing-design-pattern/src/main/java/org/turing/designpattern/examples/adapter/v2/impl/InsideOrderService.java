package org.turing.designpattern.examples.adapter.v2.impl;

import org.turing.designpattern.examples.adapter.v.service.OrderService;
import org.turing.designpattern.examples.adapter.v2.OrderAdapterService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}