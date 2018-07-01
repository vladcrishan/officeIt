package com.vlad.officeIt.strategy.rebate;

import com.vlad.officeIt.model.Order;

public interface Rebate {
    void calculatePrice(Order order);
}
