package com.adidyk;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {

    private String name;
    private int children;
    private Calendar birthday;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void SetChildren(int children) {
        this.children = children;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getNAme() {
        return this.name;
    }

    public int getChildren() {
        return this.children;
    }

    public Calendar getBirthday() {
        return this.birthday;
    }
/*
    @Override
    public String toString() {
        return String.format( "%s%s%s%s%s%s%s%s", "User{","name=", this.getNAme(),"; children=", this.getChildren(),
                "; birthday=", this.sdf.format(this.getBirthday().getTime()), "}");
    }
*/
}