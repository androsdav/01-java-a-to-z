package com.adidyk;

import java.sql.*;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.08.2018.
 * @version 1.0.
 */
public class StartUi {
    //Logger.class
    // private static final Logger log = LoggerFactory.getLogger(StartUi.class);
    //private static final Logger log = LoggerFactory.getLogger(StartUi.class);
    //private static final Logger log = LoggerFactory.getLogger(StartUi.class);

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        String url = "jdbc:postgresql://localhost:5432/base_tracker";
        String userName = "postgres";
        String password = "admin";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            new Test(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}