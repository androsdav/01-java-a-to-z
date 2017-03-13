package com.adidyk;

import java.io.IOException;

public interface UserAction {

    void execute(Command command) throws IOException;

}
