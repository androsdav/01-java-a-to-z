package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.input.ValidateInput;
import com.adidyk.setup.ConfigDataBase;
import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StartUi.class);

    /**
     * StartUi - constructor.
     * @param input - link variable to object of class Connect.
     */
    private StartUi(Input input) {
        this.input = input;
    }

    /**
     * start - starts program.
     */
    private void start() {
        this.loadSetting();
        this.configDataBase();
        this.connect();
        this.init();
        this.work();
        this.disconnect();
    }

    /**
     * loadSetting - loads params from file app.properties to class Constant.
     */
    private void loadSetting() {
        Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            setting.load(is);
            new Constant(setting);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * configDataBase - checks if there is database and checks if there is table item.
     */
    private void configDataBase() {
        this.checkDataBase();
        this.checkTables();
    }

    /**
     * checkDataBase - checks if there is database.
     */
    private void checkDataBase() {
        ConfigDataBase config = new ConfigDataBase();
        if (!config.searchDataBase()) {
            config.createDataBase();
        }
    }

    /**
     * checkTable - checks if there is table item.
     */
    private void checkTables() {
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
         } catch (SQLException ex) {
             log.error(ex.getMessage(), ex);
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
     */
    private void work() {
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
            } catch (SQLException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        Input input = new ValidateInput();
        new StartUi(input).start();
    }

}