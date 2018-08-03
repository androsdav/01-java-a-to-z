package com.adidyk;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.08.2018.
 * @version 1.0.
 */
public class Test {

    /**
     *
     */
    private Connection connection;

    /**
     *
     * @param connection - is connection.
     */
    Test(Connection connection) throws SQLException {
        this.connection = connection;
        this.selectOne();
        System.out.println();
        this.selectSecond();
    }

    private void selectOne() throws SQLException {
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM item");
        while (rs.next()) {
            System.out.println(String.format("%s  %S", rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        st.close();
    }

    private void selectSecond() throws SQLException {
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM item WHERE id = '1'");
        while (rs.next()) {
            System.out.println(String.format("%s  %S", rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        st.close();
    }

}
