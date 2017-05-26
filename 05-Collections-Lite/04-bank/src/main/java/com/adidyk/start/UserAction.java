package com.adidyk.start;

public interface UserAction {

    int key();

    void execute(Input input, Bank bank);

    String info();
}
