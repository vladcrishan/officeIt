package com.vlad.officeIt.model;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private Price price;
    private final Client client;
    private final List<Product> products;

    public Order(Client client, List<Product> products) {
        this.id = UUID.randomUUID().toString();
        this.client = client;
        this.products = products;

        this.price = calculateInitialPrice();
    }

    private Price calculateInitialPrice() {
        Integer totalPrice = 0;
        for (Product cursor : this.products) {
            totalPrice += cursor.getPrice();
        }

        return new Price(totalPrice);
    }

    public int getInitialPrice() {
        return price.getInitialPrice();
    }

    public Integer getFinalPrice() {
        return price.getFinalPrice();
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", client=" + client +
                ", products=" + products +
                '}';
    }
}
