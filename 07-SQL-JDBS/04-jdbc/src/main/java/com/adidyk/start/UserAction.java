package com.adidyk.start;

import java.sql.SQLException;

public interface UserAction {

    int key();

    void execute(Input input, Tracker track) throws SQLException;

    String info();
}
