package com.vlad.officeIt.service;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.strategy.rebate.Rebate;
import com.vlad.officeIt.strategy.rebate.RebateFactory;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private RebateFactory rebateFactory;

    public PriceService() {
        this.rebateFactory = new RebateFactory();
    }

    public Price calculatePrice(Order order) {
        Rebate rebate = rebateFactory.getRebate(order.getClient().getRebateType());
        return rebate.calculatePrice(order);
    }
}
