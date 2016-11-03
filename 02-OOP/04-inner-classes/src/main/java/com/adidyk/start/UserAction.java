package com.adidyk.start;

public interface UserAction {

    int key();

    void execute(Input input, Tracker track);

    String info();
}
