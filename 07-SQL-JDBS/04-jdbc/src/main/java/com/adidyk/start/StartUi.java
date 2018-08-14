package com.adidyk.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.08.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     *
     */
    private Input input;

    /**
     *
     */
    private Tracker tracker;

    /**
     *
     */
    private String url = "jdbc:postgresql://localhost:5432/base_tracker";

    /**
     *
     */
    private String userName = "postgres";

    /**
     *
     */
    private String password = "admin";

    /**
     *
     */
    private Connection connect = null;

    /**
     *
     */
    private MenuTracker menu;

    /**
     *
     * @param input - is input.
     * @throws SQLException - is exception.
     */
    private StartUi(Input input) throws SQLException {
        this.input = input;
    }

    /**
     *
     * @throws SQLException - is exception.
     */
    private void start() throws SQLException {
        this.connect();
        this.init();
        this.work();
        this.disconnect();
    }

    /**
     *
     */
     private void connect()  {
         try {
             this.connect = DriverManager.getConnection(this.url, this.userName, this.password);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    /**
     *
     */
    private void init() {
        this.tracker = new Tracker(this.connect);
        this.menu = new MenuTracker(this.input, this.tracker);

    }

    /**
     *
     * @throws SQLException - is exception.
     */
    private void work() throws SQLException {
        this.menu.fillAction();
        while(true) {
            this.menu.show();
            int key = this.input.ask(" Choose key: ", this.menu.getIndexActions());
            this.menu.select(key);
            if (key == 9) break;
        }
    }

    /**
     *
     */
    private void disconnect() {
        if (this.connect != null) {
            try {
                this.connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) throws SQLException {

        Input input = new ValidateInput();
        new StartUi(input).start();
    }

}