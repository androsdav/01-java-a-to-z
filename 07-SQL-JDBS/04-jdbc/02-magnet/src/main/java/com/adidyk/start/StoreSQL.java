package com.adidyk.start;

import com.adidyk.models.Item;

import java.sql.*;

import static com.adidyk.setup.Constant.*;

//import static com.adidyk.setup.Constant.*;
//import static com.adidyk.setup.Constant.ITEM;
//import static com.adidyk.setup.Constant.TABLE_NAME;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
class StoreSQL {

    /**
     * @param config - link variable to object of class Config.
     */
    private Config config;

    /**
     * StoreSqQL - constructor.
     * @param config - link variable to object of class config.
     */
    StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * searchTable - searches table (query sql) ITEM (item). If table item exists then method returns true,
     * if table item does not exists then method returns false.
     * @throws SQLException - sql exception.
     * @return - returns true if table item exists, false - does not exists..
     */
    boolean searchTable() throws SQLException {
        boolean result = false;
        Connection connect = DriverManager.getConnection(this.config.getUrl());
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM main.sqlite_master WHERE main.sqlite_master.tbl_name = 'entry'");
        while (rs.next()) {
            if ("entry".equals(rs.getString("tbl_name"))) {
                result = true;
                break;
            }
        }
        rs.close();
        st.close();
        connect.close();
        return result;
    }

    /**
     * createTableItem - connect to database base_tracker and creates table item.
     * @throws SQLException - is sql exception.
     */
    void createTable() throws SQLException {
        Connection connect = DriverManager.getConnection(this.config.getUrl());
        connect.createStatement().executeUpdate("CREATE TABLE entry (field integer)");
        connect.close();
    }

    /**
     * generate - generate.
     * @param quantity   -  is quantity.
     * @throws SQLException - is SQL exception.
     */
    void generate(int quantity) throws SQLException {
        for (int counter = 0; counter < quantity; counter ++) {
            this.addField(counter);
        }
    }

    /**
     * addItem - adds new item to item table in database base_tracker
     * (used query sql -> ADD_ITEM).
     * @param counter - link variable to object of class Item.
     * @throws SQLException - is SQL exception.
     */
    void addField(int counter) throws SQLException {
        Connection connect = DriverManager.getConnection(this.config.getUrl());
        PreparedStatement st = connect.prepareStatement("INSERT INTO entry(field) VALUES (?)");
        st.setInt(1, counter);
        st.executeUpdate();
        st.close();
        connect.close();
    }

}