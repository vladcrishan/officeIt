package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.strategy.rebate.Rebate;

public class VolumeRebate implements Rebate {
    @Override
    public void calculatePrice(Order order) {

        // apply rebate
        if (order.getProducts().size() > 2) {
            order.setFinalPrice(order.getFinalPrice() - 10);
        }

    }
}
