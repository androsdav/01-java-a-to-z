package com.adidyk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 25.07.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        String HOST = "jdbc:postgresql://localhost:5432/base_item";
        String USERNAME = "postgres";
        String PASSWORD = "admin";
        Connection connection;
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println("database " + connection.getCatalog() + " connect ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}