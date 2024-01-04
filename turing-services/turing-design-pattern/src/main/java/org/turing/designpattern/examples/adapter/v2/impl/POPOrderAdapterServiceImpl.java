package org.turing.designpattern.examples.adapter.v2.impl;

import org.turing.designpattern.examples.adapter.v.service.POPOrderService;
import org.turing.designpattern.examples.adapter.v2.OrderAdapterService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}