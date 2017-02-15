package com.adidyk;

import java.io.IOException;

public interface UserAction {

    String key();

    void execute(Command command) throws IOException;

    String info();

}
