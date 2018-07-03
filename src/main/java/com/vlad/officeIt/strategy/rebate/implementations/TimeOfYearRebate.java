package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.strategy.rebate.Rebate;

import java.time.MonthDay;

public class TimeOfYearRebate implements Rebate {
    @Override
    public Price calculatePrice(Order order) {

        Price price = new Price(order.getInitialPrice(), order.getInitialPrice());

        // apply rebate, black friday
        if (MonthDay.now() == MonthDay.of(11, 23)) {
            price.setFinalPrice(order.getInitialPrice() - 20);
        }

        return price;
    }
}
