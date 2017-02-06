package com.adidyk;

public interface UserAction {

    int key();
    void execute(Input input, Api api);
    String info();


}
