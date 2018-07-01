package com.vlad.officeIt.strategy.rebate.implementations;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.strategy.rebate.Rebate;

import java.time.MonthDay;

public class TimeOfYearRebate implements Rebate {
    @Override
    public void calculatePrice(Order order) {

        // apply rebate, black friday
        if (MonthDay.now() == MonthDay.of(11, 23)) {
            order.setFinalPrice(order.getFinalPrice() - 20);
        }
        
    }
}
