package com.vlad.officeIt.model;

public class Price {
    private final Integer initialPrice;
    private Integer finalPrice;

    public Price(Integer initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Price(Integer initialPrice, Integer finalPrice) {
        this.initialPrice = initialPrice;
        this.finalPrice = finalPrice;
    }

    public Integer getInitialPrice() {
        return initialPrice;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "initialPrice=" + initialPrice +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
