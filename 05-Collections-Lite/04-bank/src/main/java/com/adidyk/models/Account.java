package com.adidyk.models;

public class Account {

    private String requisites;
    private double value;

    public Account(String requisites) {
        this.requisites = requisites;
        this.value = 0;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void addValue(double value) {
        this.value = this.value + value;
    }

    public void subValue(double value) {
        this.value = this.value - value;
    }

    public String getRequisites(){
        return this.requisites;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;

    }

    @Override
    public int hashCode() {
        return requisites != null ? requisites.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("%s%10s%s%13s%s%s",
                "|", this.getRequisites(), " | ", this.getValue(), " $", "|");
    }

}
