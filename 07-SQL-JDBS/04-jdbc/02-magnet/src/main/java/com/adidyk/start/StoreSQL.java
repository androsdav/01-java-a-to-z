package com.adidyk.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import static com.adidyk.setup.Constant.*;

/**
 * Class StoreSQL used for check structure database.
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
     * searchTable - searches table (query sql) ENTRY (entry). If table item exists then method returns true,
     * if table item does not exists then method returns false.
     * @return - returns true if table item exists, false - does not exists.
     */
    boolean searchTable() {
        boolean found = false;
        try (Connection connect = DriverManager.getConnection(URL);
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(SEARCH_TABLE_ENTRY)) {
            while (result.next()) {
                if (ENTRY.equals(result.getString(TABLE_NAME))) {
                    found = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        return found;
    }

    /**
     * createTableItem - connect to database magnet.sqlite and creates table entry.
     */
    void createTable() {
        try (Connection connect = DriverManager.getConnection(URL)) {
            connect.createStatement().executeUpdate(CREATE_TABLE_ENTRY);
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * generate - generates number of fields in table entry.
     * @param quantity - number of fields in entry.
     */
    void generate(int quantity) {
        this.clearTable();
        try (Connection connect = DriverManager.getConnection(URL)) {
            connect.setAutoCommit(false);
            try (PreparedStatement statement = connect.prepareStatement(ADD_FIELD)) {
                for (int counter = 1; counter <= quantity; counter++) {
                    statement.setInt(1, counter);
                    statement.executeUpdate();
                }
            } catch (SQLException ex) {
                connect.rollback();
            }
            connect.commit();
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * clearTable - clears all fields in table entry.
     */
    private void clearTable() {
        try (Connection connect = DriverManager.getConnection(URL)) {
            connect.createStatement().executeUpdate(CLEAR_TABLE_ENTRY);
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}