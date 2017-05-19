package com.adidyk;

public class User {

    private Integer id;
    private String name;
    private String city;

    User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

}
