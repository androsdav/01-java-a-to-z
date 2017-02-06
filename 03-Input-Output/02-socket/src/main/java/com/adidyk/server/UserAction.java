package com.adidyk.server;

public interface UserAction {

    int key();
    void execute(Input input, Api api);
    String info();


}
