package com.adidyk;

public class User {

    private long id;
    private String name;
    private String city;

    User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setid(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

}
