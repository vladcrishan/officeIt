package com.vlad.officeIt.strategy.rebate;

import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;

public interface Rebate {
    Price calculatePrice(Order order);
}
