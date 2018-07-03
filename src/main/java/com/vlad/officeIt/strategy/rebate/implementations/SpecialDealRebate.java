package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.strategy.rebate.Rebate;

public class SpecialDealRebate implements Rebate {

    @Override
    public Price calculatePrice(Order order) {

        Price price = new Price(order.getInitialPrice(), order.getInitialPrice());

        // Order price bigger than 40
        if (order.getInitialPrice() > 40) {
            price.setFinalPrice(order.getInitialPrice() - 30);
        }

        return price;
    }
}
