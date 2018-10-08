package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.setup.ConfigDataBase;
import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 28.09.2018.
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
        //this.loadSetting();
        //this.configDataBase();
        this.connect();
        //this.init();
        //this.work();
        //this.disconnect();
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
             this.connect = DriverManager.getConnection("jdbc:sqlite:magnet.db");
             System.out.println("database connect ...");
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
        //Input input = new ValidateInput();
        //new StartUi(input).start();
        List<Customer> customers = new ArrayList<>();
        // customer
        Customer artur = new Customer();
        artur.setId(1);
        artur.setName("artur");
        artur.setAge(20);
        Customer dilan = new Customer();
        dilan.setId(2);
        dilan.setName("dilan");
        dilan.setAge(21);
        Customer bob = new Customer();
        bob.setId(3);
        bob.setName("bob");
        bob.setAge(22);
        Customer bill = new Customer();
        bill.setId(4);
        bill.setName("bill");
        bill.setAge(27);
        Customer amanda = new Customer();
        amanda.setId(5);
        amanda.setName("amanda");
        amanda.setAge(54);
        Customer adolf = new Customer();
        adolf.setId(6);
        adolf.setName("adolf");
        adolf.setAge(44);
        // list customers
        List<Customer> customers1 = new ArrayList<>();
        customers1.add(artur);
        customers1.add(dilan);
        customers1.add(bob);
        List<Customer> customers2 = new ArrayList<>();
        customers2.add(bill);
        customers2.add(amanda);
        List<Customer> customers3 = new ArrayList<>();
        customers3.add(adolf);
        // group
        Group first = new Group();
        first.setName("first");
        first.setCustomers(customers1);
        Group second = new Group();
        second.setName("second");
        second.setCustomers(customers2);
        Group third = new Group();
        third.setName("third");
        third.setCustomers(customers3);

        try {
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class, Group.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(first, file);
            marshaller.marshal(first, System.out);
            //marshaller.marshal(artur, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Config config = new Config();
        StoreSQL store = new StoreSQL(config);
        if (!store.searchTable()) {
            store.createTable();
        }
        store.generate(17);
    }

}