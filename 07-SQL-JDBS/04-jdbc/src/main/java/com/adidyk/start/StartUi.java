package com.adidyk.start;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import com.adidyk.setup.*;
import static com.adidyk.setup.Constant.*;


/**
 * Class StartUi for create jar file and connect to data base.
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
    private Connection connect = null;

    /**
     *
     */
    private MenuTracker menu;

    /**
     * StartUi - constructor.
     * @param input - is input.
     * @throws SQLException - is exception.
     */
    private StartUi(Input input) throws SQLException {
        this.input = input;
    }

    /**
     * start  - is start.
     * @throws SQLException - is exception.
     */
    private void start() throws SQLException, IOException {
        this.loadConfig();
        this.connect();
        this.init();
        this.work();
        this.disconnect();
    }

    // loadConfig - loading settings from file "app.properties"

    /**
     * loadConfig - is config.
     * @throws IOException - is io exception.
     */
    private void loadConfig() throws IOException {
        Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            setting.load(is);
            new Constant(setting);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * connect - is connect.
     */
     private void connect()  {
         try {
             this.connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME_BASE_TRACKER, PASSWORD);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    /**
     * init - is init.
     */
    private void init() {
        this.tracker = new Tracker(this.connect);
        this.menu = new MenuTracker(this.input, this.tracker);

    }

    /**
     * work - is work.
     * @throws SQLException - is exception.
     */
    private void work() throws SQLException {
        this.menu.fillAction();
        while(true) {
            this.menu.show();
            int key = this.input.ask(" Choose key: ", this.menu.getIndexActions());
            this.menu.select(key);
            if (key == 10) break;
        }
    }

    /**
     * disconnect - is disconnect.
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
    public static void main(String[] arg) throws SQLException, IOException, ClassNotFoundException {

        Input input = new ValidateInput();
        new StartUi(input).start();

        /*
        loadConfig();
        ConfigDataBase config = new ConfigDataBase();
        //System.out.println(config.searchDataBase());
        if (!config.searchDataBase()) {
            System.out.println("[info]: create database ...");
            config.createDataBase();
        } else {
            System.out.println("[info]: database already created ...");
        }
        */
        //createDB.createDB();
    }

}