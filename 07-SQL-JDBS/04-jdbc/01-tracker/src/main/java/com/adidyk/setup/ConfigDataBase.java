package com.adidyk.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static com.adidyk.setup.Constant.*;

/**
 * Class ConfigDataBase used to check the availability of the database and its structure.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class ConfigDataBase {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ConfigDataBase.class);

    /**
     * searchDataBase - searches database (query sql) NAME_DATA_BASE (base_tracker). If database base_tracker exists
     * then method returns true, if database base_tracker does not exists then method returns false.
     * @return - returns true if database base_tracker exists, false - does not exists.
     */
    public boolean searchDataBase()  {
        boolean found = false;
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(SEARCH_DATA_BASE);
            while (result.next()) {
                if (NAME_DATA_BASE.equals(result.getString(DAT_NAME))) {
                    found = true;
                }
            }
            result.close();
            statement.close();
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }
        return found;
    }

    /**
     * searchTable - searches table (query sql) ITEM (item). If table item exists then method returns true,
     * if table item does not exists then method returns false.
     * @return - returns true if table item exists, false - does not exists.
     */
    public boolean searchTables() {
        boolean found = false;
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(SEARCH_TABLE);
            while (result.next()) {
                if (ITEM.equals(result.getString(TABLE_NAME))) {
                    found = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }
        return found;
    }

    /**
     * createDataBase - connects to database postgres and creates database base_tracker.
     */
    public void createDataBase() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
            connect.createStatement().executeUpdate(CREATE_DATA_BASE);
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }
    }

    /**
     * createTableItem - connect to database base_tracker and creates table item.
     */
    public void createTableItem() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
            connect.createStatement().executeUpdate(CREATE_TABLE_ITEM);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }
    }

    /**
     * createTableComments - connect to database base_tracker and crates table comments.
     */
    public void createTableComments() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL_BASE_TRACKER, NAME, PASSWORD);
            connect.createStatement().executeUpdate(CREATE_TABLE_COMMENTS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }
    }

}