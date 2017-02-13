package com.adidyk;

import java.io.IOException;

public interface UserAction {

    String key();
    void execute(Api api, String row) throws IOException;
    String info();


}
