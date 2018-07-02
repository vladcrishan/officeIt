package com.vlad.officeIt.model;


import com.vlad.officeIt.strategy.rebate.RebateType;

import java.io.Serializable;

public class Client implements Serializable {

    private final Integer id;
    private final String name;
    private final RebateType rebateType;

    public Client(Integer id, String name, RebateType rebateType) {
        this.id = id;
        this.name = name;
        this.rebateType = rebateType;
    }

    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public RebateType getRebateType() {
        return rebateType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rebateType=" + rebateType +
                '}';
    }
}
