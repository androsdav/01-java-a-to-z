package com.adidyk.start;

import com.adidyk.models.Item;
//import com.sun.demo.jvmti.hprof.Tracker;
//import com.sun.demo.jvmti.hprof.Tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

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

    private Input input;
    private Tracker track;

    private StartUi(Input input) {
        this.input = input;
        this.track = new Tracker();
        this.track.addItem(new Item("task0", "desc0", new Date().getTime()));
        this.track.addItem(new Item("task1", "desc1", new Date().getTime()));
        this.track.addItem(new Item("task2", "desc2", new Date().getTime()));
        this.track.addItem(new Item("task3", "desc3", new Date().getTime()));
    }

    // init - initialization and start work
    private void init() {
        MenuTracker menu = new MenuTracker(this.input, this.track);
        menu.fillAction();
        while(true) {
            menu.show();
            int key = this.input.ask(" Choose key: ", menu.getIndexActions());
            menu.select(key);
            if (key == 9) break;
        }
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {

        Input input = new ValidateInput();
        new StartUi(input).init();

        Item item0 = new Item("task0", "desc0", new Date().getTime());
        Item item1 = new Item("task1", "desc1", new Date().getTime());
        Item item2 = new Item("task2", "desc2", new Date().getTime());
        Item item3 = new Item("task3", "desc3", new Date().getTime());

        String url = "jdbc:postgresql://localhost:5432/base_tracker";
        String userName = "postgres";
        String password = "admin";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            Tracker tracker = new Tracker(connection);
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