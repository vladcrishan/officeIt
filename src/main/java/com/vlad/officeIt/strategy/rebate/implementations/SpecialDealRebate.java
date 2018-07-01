package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.strategy.rebate.Rebate;

public class SpecialDealRebate implements Rebate {

    @Override
    public void calculatePrice(Order order) {

        // apply rebate, if client Visma
        if (order.getClient().getName().equals("Visma")) {
            order.setFinalPrice(order.getFinalPrice() - 30);
        }
    }
}
