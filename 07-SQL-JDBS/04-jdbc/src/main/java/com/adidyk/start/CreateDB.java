package com.adidyk.start;

import java.sql.*;

import static com.adidyk.setup.Constant.*;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */

class CreateDB {
    //static final String DATABASE_URL = "jdbc:mysql://localhost/";
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String USER = "ВАШЕ_ИМЯ_ПОЛЬЗОВАТЕЛЯ";
    //static final String PASSWORD = "ВАШ_ПАРОЛЬ";
    void createDB() throws ClassNotFoundException, SQLException {
        Connection connect;
        Statement st;
        connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", NAME, PASSWORD);
        st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT datname FROM pg_database WHERE datname = 'base01'");
        while (rs.next()) {

        }
        //System.out.println(result);
        if (result) {
            System.out.println("data base is exists ...");
        } else {
            System.out.println("data base is not exists ...");
        }
        st.close();
        connect.close();
        /*
        Connection connect = null;
        boolean haveBase;
        try {
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/new_base_2", NAME, PASSWORD);
            System.out.println("new_base_2 exists ...");
            haveBase = true;
        } catch (SQLException e) {
            System.out.println("new_base_2 does not exists ...");
            //e.printStackTrace();
            haveBase = false;
        }
        finally {
            if(connect!=null){
                connect.close();
            }
        }
        if (haveBase) {
            try {
                connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", NAME, PASSWORD);
                System.out.println("new_base_2 create ...");
                connect.createStatement().executeUpdate("CREATE DATABASE new_base_2");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if(connect!=null){
                    connect.close();
                }
            }

        }
        */
    }
}