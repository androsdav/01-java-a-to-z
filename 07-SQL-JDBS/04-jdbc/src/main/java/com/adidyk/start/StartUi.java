package com.adidyk.start;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.adidyk.input.Input;
import com.adidyk.input.ValidateInput;
import com.adidyk.setup.*;
import static com.adidyk.setup.Constant.*;


/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.08.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param input - link variable to object ValidateInput.
     */
    private Input input;


    /**
     * @param connect - link variable to object of class Connect.
     */
    private Connection connect = null;

    /**
     * @param menu - link variable to object of class MenuTracker.
     */
    private MenuTracker menu;

    /**
     * StartUi - constructor.
     * @param input - link variable to object of class Connect.
     * @throws SQLException - is exception.
     */
    private StartUi(Input input) throws SQLException {
        this.input = input;
    }

    /**
     * start - starts program.
     * @throws SQLException - sql exception.
     * @throws IOException - io exception.
     * @throws ClassNotFoundException - class not found exception.
     */
    private void start() throws SQLException, IOException, ClassNotFoundException {
        this.loadSetting();
        this.configDataBase();
        this.connect();
        this.init();
        this.work();
        this.disconnect();
    }

    /**
     * loadSetting - loads params from file app.properties to class Constant.
     * @throws IOException - io exception.
     */
    private void loadSetting() throws IOException {
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
     * configDataBase - checks if there is database and checks if there is table item.
     * @throws SQLException - sql exception.
     * @throws ClassNotFoundException - class not found exception.
     */
    private void configDataBase() throws SQLException, ClassNotFoundException {
        this.checkDataBase();
        this.checkTables();
    }

    /**
     * checkDataBase - checks if there is database.
     * @throws SQLException - sql exception.
     * @throws ClassNotFoundException - class not found exception.
     */
    private void checkDataBase() throws SQLException, ClassNotFoundException {
        ConfigDataBase config = new ConfigDataBase();
        if (!config.searchDataBase()) {
            config.createDataBase();
        }
    }

    /**
     * checkTable - checks if there is table item.
     * @throws SQLException - sql exception.
     */
    private void checkTables() throws SQLException {
        ConfigDataBase config = new ConfigDataBase();
        if (!config.searchTables()) {
            config.createTableItem();
            config.createTableComments();
        }
    }

    /**
     * connect - connects to database base_tracker.
     */
     private void connect()  {
         try {
             this.connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    /**
     * init - initialization parameters tracker and menu.
     */
    private void init() {
        Tracker tracker = new Tracker(this.connect);
        this.menu = new MenuTracker(this.input, tracker);
    }

    /**
     * work - starts to works program.
     * @throws SQLException - sql exception.
     */
    private void work() throws SQLException {
        this.menu.fillAction();
        while (true) {
            this.menu.show();
            int key = this.input.ask(" Choose key: ", this.menu.getIndexActions());
            this.menu.select(key);
            if (key == this.menu.getIndexActions().length) {
                break;
            }
        }
    }

    /**
     * disconnect - disconnect to database base_tracker.
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
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     * @throws SQLException - sql exception.
     * @throws IOException - io exception.
     * @throws ClassNotFoundException - class not found exception.
     */
    public static void main(String[] arg) throws SQLException, IOException, ClassNotFoundException {
        Input input = new ValidateInput();
        new StartUi(input).start();
    }

}