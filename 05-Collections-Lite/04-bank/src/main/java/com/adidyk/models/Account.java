package com.adidyk.models;

public class Account {

    private long requisites;
    private double value;

    public Account(long requisites) {
        this.requisites = requisites;
    }

    public void setRequisites(long requisites) {
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = this.value + value;
    }

    public long getRequisites(){
        return this.requisites;
    }

    public double getValue() {
        return this.value;
    }
}
