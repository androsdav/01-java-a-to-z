package com.adidyk.start;

import java.sql.SQLException;

public abstract class BaseAction implements UserAction {

   private String name;

   BaseAction(String name) {
       this.name = name;
   }

    public abstract int key();

    public abstract void execute(Input input, Tracker track) throws SQLException;

    public String info() {
        return String.format(" %s%s%s", this.key(), ".", this.name);
    }

}
