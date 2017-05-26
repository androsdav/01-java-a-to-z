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

    public void setValue(double value) {
        this.value = this.value + value;
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
        if (Double.compare(account.value, value) != 0) return false;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = requisites != null ? requisites.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%s%10s%s",
                "  requisites: ", this.getRequisites(), "    value: ", this.getValue(), " $");
    }
}
