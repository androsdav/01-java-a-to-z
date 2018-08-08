package com.adidyk;

import com.adidyk.models.Item;
//import com.sun.demo.jvmti.hprof.Tracker;
//import com.sun.demo.jvmti.hprof.Tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import com.adidyk.start.*;

//import java.sql.*;

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
        Item item0 = new Item("task0", "desc0", new Date().getTime());
        Item item1 = new Item("task1", "desc1", new Date().getTime());
        Item item2 = new Item("task2", "desc2", new Date().getTime());
        Item item3 = new Item("task3", "desc3", new Date().getTime());
        //System.out.println(item0);
        //System.out.println(item1);
        String url = "jdbc:postgresql://localhost:5432/base_tracker";
        String userName = "postgres";
        String password = "admin";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            //new Test(connection);
            Tracker tracker = new Tracker(connection);
            //tracker.addItem(item0);
            //tracker.addItem(item1);
            //tracker.addItem(item2);
            //tracker.addItem(item3);
            System.out.println();
            System.out.println(tracker.searchItemById("16"));
            Item item4 = new Item("update", "update", new Date().getTime());
            item4.setId("15");
            tracker.updateItemById(item4);
            //tracker.removeItemById("9");
            //tracker.getAllItem();
            for (Item item : tracker.getAllItem()) {
                System.out.println(item);
            }
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