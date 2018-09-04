package com.adidyk.setup;

import java.sql.*;
import static com.adidyk.setup.Constant.*;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class ConfigDataBase {

    /**
     * searchDataBase - searches database (query sql) NAME_DATA_BASE (base_tracker). If database base_tracker exists
     * then method returns true, if database base_tracker does not exists then method returns false.
     * @throws ClassNotFoundException - class not found exception.
     * @throws SQLException - sql exception.
     * @return - returns true if database base_tracker exists, false - does not exists.
     */
    public boolean searchDataBase() throws ClassNotFoundException, SQLException {
        boolean result = false;
        Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(SEARCH_DATA_BASE);
        while (rs.next()) {
            if (NAME_DATA_BASE.equals(rs.getString("datname"))) {
                result = true;
            }
        }
        rs.close();
        st.close();
        connect.close();
        return result;
    }

    /**
     * searchTable - searches table (query sql) ITEM (item). If table item exists then method returns true,
     * if table item does not exists then method returns false.
     * @throws SQLException - sql exception.
     * @return - returns true if table item exists, false - does not exists..
     */
    public boolean searchTables() throws SQLException {
        boolean result = false;
        Connection connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(SEARCH_TABLE);
        while (rs.next()) {
            if ("item".equals(rs.getString("table_name"))) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @throws SQLException - is exception.
     */
    public void createDataBase() throws SQLException {
        Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
        connect.createStatement().executeUpdate(CREATE_DATA_BASE);
        connect.close();
    }

    /**
     * createTableItem - creates table item.
     * @throws SQLException - is sql exception.
     */
    public void createTableItem() throws SQLException {
        Connection connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
        connect.createStatement().executeUpdate(CREATE_TABLE_ITEM);
        connect.close();
    }

    /**
     * createTableItem - creates table item.
     * @throws SQLException - is sql exception.
     */
    public void createTableComments() throws SQLException {
        Connection connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
        connect.createStatement().executeUpdate(CREATE_TABLE_COMMENTS);
        connect.close();
    }

}