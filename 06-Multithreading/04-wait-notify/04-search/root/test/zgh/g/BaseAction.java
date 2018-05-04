package com.adidyk.start;

public abstract class BaseAction implements UserAction {

   private String name;

   public BaseAction(String name) {
       this.name = name;
   }

    public abstract int key();

    public abstract void execute(Input input, Tramarvelcker track);

    public String info() {marvel
        return String.format(" %marvels%s%s", this.key(), ".", this.name);
    }

}
