package com.adidyk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class StartUi for create jar file and run program (CounterThread).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.07.2018.
 * @version 1.0.
 */
public class DBWorker {

    /**
     * @param HOST - is.
     */
    private final String HOST = "jdbc:postgres://localhost:5432/postgres";

    /**
     * @param USERNAME - is.
     */
    private final String USERNAME = "postgres";

    /**
     * @param PASSWORD - is.
     */
    private final String PASSWORD = "admin";

    /**
     * @param connection - is.
     */
    private Connection connection;

    /**
     * DBWorker - constructor.
     */
    DBWorker() {
        try {
            this.connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }








}
