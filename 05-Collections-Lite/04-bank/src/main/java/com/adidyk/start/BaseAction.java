package com.adidyk.start;

public abstract class BaseAction implements UserAction {

   private String name;

   public BaseAction(String name) {
       this.name = name;
   }

    public abstract int key();

    public abstract void execute(Input input, Bank bank);

    public String info() {
        return String.format(" %s%s%s", this.key(), ".", this.name);
    }

}
