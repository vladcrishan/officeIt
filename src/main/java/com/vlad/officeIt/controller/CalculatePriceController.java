package com.vlad.officeIt.controller;

import com.vlad.officeIt.model.Client;
import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.service.PriceService;
import com.vlad.officeIt.strategy.rebate.RebateType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculatePriceController {

    private PriceService priceService = new PriceService();
    private Integer orderID = 0;

    @RequestMapping("/price")
    public String price() {

        Client client = new Client(1, "Visma", RebateType.VOLUME);
        List<Product> products = new ArrayList<Product>() {{
            add(new Product(1, 11, "Scaun", "blabla"));
            add(new Product(2, 12, "Birou", "hapciu"));
            add(new Product(3, 13, "Etajeră", "123"));
        }};

        Order order = createOrder(client, products);
        return priceService.calculatePrice(order).toString();
    }

    private Order createOrder(Client client, List<Product> products) {

        // calculate total original price
        Integer originalPrice = 0;
        for (Product cursor : products) {
            originalPrice += cursor.getPrice();
        }

        return new Order(orderID++, originalPrice, originalPrice, client, products);
    }
}
