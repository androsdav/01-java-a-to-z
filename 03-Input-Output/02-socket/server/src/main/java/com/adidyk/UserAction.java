package com.adidyk;

import java.io.IOException;

public interface UserAction {

    //int key();
    void execute(Api api, String row) throws IOException;
    //String info();


}
