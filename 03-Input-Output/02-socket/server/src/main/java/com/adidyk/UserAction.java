package com.adidyk;

public interface UserAction {

    int key();
    void execute(String str, Api api);
    String info();


}
