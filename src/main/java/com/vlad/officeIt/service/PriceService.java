package com.vlad.officeIt.service;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.strategy.rebate.Rebate;
import com.vlad.officeIt.strategy.rebate.RebateFactory;

public class PriceService {

    private RebateFactory rebateFactory;

    public PriceService() {
        this.rebateFactory = new RebateFactory();
    }

    public Integer calculatePrice(Order order) {
        Rebate rebate = rebateFactory.getRebate(order.getClient().getRebateType());
        rebate.calculatePrice(order);
        return order.getFinalPrice();
    }
}
