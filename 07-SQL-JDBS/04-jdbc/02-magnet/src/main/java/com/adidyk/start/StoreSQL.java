package com.adidyk.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import static com.adidyk.setup.Constant.*;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
class StoreSQL {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StoreSQL.class);

    /**
     * searchTable - searches table (query sql) ITEM (item). If table item exists then method returns true,
     * if table item does not exists then method returns false.
     * @return - returns true if table item exists, false - does not exists..
     */
    boolean searchTable() {
        boolean found = false;
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL);
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(SEARCH_TABLE_ENTRY);
            while (result.next()) {
                if (ENTRY.equals(result.getString("tbl_name"))) {
                    found = true;
                    break;
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
     * createTableItem - connect to database base_tracker and creates table item.
     */
    void createTable() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL);
            connect.createStatement().executeUpdate(CREATE_TABLE_ENTRY);
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
     * generate - generate.
     * @param quantity   -  is quantity.
     * @throws SQLException - is SQL exception.
     */
    void generate(int quantity) throws SQLException {
        this.clearTable();
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL);
            connect.setAutoCommit(false);
            PreparedStatement statement = connect.prepareStatement(ADD_FIELD);
            for (int counter = 1; counter <= quantity; counter++) {
                statement.setInt(1, counter);
                statement.executeUpdate();
            }
            connect.commit();
            statement.close();
        } catch (SQLException ex) {
            if (connect != null) {
                connect.rollback();
            }
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
     * clearTable - clears table.
     */
    private void clearTable() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL);
            connect.createStatement().executeUpdate(CLEAR_TABLE_ENTRY);
        } catch (SQLException e) {
            e.printStackTrace();
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

}