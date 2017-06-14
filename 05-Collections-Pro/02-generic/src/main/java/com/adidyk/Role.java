package com.adidyk;

public class Role extends Base {

    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    String getId() {
        return this.id;
    }
}
