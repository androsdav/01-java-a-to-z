package com.adidyk;

public class User extends Base {

    private String id;
    private String name;

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
