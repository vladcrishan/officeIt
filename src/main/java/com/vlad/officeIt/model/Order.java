package com.vlad.officeIt.model;

import java.util.List;

public class Order {
    private Integer id;
    private Integer originalPrice;
    private Integer finalPrice;
    private Client client;
    private List<Product> products;

    public Order(Integer id, Integer originalPrice, Integer finalPrice, Client client, List<Product> products) {
        this.id = id;
        this.originalPrice = originalPrice;
        this.finalPrice = finalPrice;
        this.client = client;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", originalPrice=" + originalPrice +
                ", finalPrice=" + finalPrice +
                ", client=" + client +
                ", products=" + products +
                '}';
    }
}
