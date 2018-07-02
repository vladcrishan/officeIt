package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.strategy.rebate.Rebate;

public class SpecialDealRebate implements Rebate {

    @Override
    public Price calculatePrice(Order order) {

        Price price = new Price(order.getInitialPrice());

        // apply rebate, if client Visma
        if (order.getClient().getName().equals("Visma")) {
            price.setFinalPrice(order.getInitialPrice() - 30);
        }

        return price;
    }
}
