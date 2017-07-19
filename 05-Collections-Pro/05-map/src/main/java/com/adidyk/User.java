package com.adidyk;

import java.util.Calendar;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    void setName(String name) {
        this.name = name;
    }

    void SetChildren(int children) {
        this.children = children;
    }

    void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    String getNAme() {
        return this.name;
    }

    int getChildren() {
        return this.children;
    }

    Calendar getBirthday() {
        return this.birthday;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.children;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        return result;
    }

}