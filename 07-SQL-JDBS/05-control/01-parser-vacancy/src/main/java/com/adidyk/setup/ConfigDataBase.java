package com.adidyk.setup;

import org.apache.log4j.Logger;
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
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(ConfigDataBase.class);

    /**
     * searchDataBase - searches database (query sql) NAME_DATA_BASE (base_vacancy). If database base_vacancy exists
     * then method returns true, if database base_vacancy does not exists then method returns false.
     * @return - returns true if database base_vacancy exists, false - does not exists.
     */
    public boolean searchDataBase()  {
        boolean found = false;
        try (Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, USER_NAME, PASSWORD);
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(SEARCH_DATA_BASE)) {
            while (result.next()) {
                if (NAME_DATA_BASE.equals(result.getString(DAT_NAME))) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return found;
    }

    /**
     * searchTable - searches table (query sql) vacancy. If table vacancy exists then method returns true,
     * if table vacancy does not exists then method returns false.
     * @return - returns true if table vacancy exists, false - does not exists.
     */
    public boolean searchTable() {
        boolean found = false;
        try (Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(SEARCH_TABLE_VACANCY)) {
            while (result.next()) {
                if (VACANCY.equals(result.getString(TABLE_NAME))) {
                    found = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return found;
    }

    /**
     * createDataBase - connects to database postgres and creates database base_vacancy.
     */
    public void createDataBase() {
        try (Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, USER_NAME, PASSWORD)) {
            connect.createStatement().executeUpdate(CREATE_DATA_BASE);
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * createTableVacancy - connect to database base_vacancy and creates table vacancy.
     */
    public void createTableVacancy() {
        try (Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD)) {
            connect.createStatement().executeUpdate(CREATE_TABLE_VACANCY);
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

}