package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.strategy.rebate.Rebate;

public class VolumeRebate implements Rebate {
    @Override
    public Price calculatePrice(Order order) {

        Price price = new Price(order.getInitialPrice());

        // apply rebate
        if (order.getProducts().size() > 2) {
            price.setFinalPrice(order.getInitialPrice() - 10);
        }

        return price;
    }
}
