package com.vlad.officeIt.model;


import com.vlad.officeIt.strategy.rebate.RebateType;

import java.io.Serializable;

public class Client implements Serializable {

    private Integer id;
    private String name;
    private RebateType rebateType;

    public Client(Integer id, String name, RebateType rebateType) {
        this.id = id;
        this.name = name;
        this.rebateType = rebateType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RebateType getRebateType() {
        return rebateType;
    }

    public void setRebateType(RebateType rebateType) {
        this.rebateType = rebateType;
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
