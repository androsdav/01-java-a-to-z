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
public class ConfigDataBase implements AutoCloseable {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(ConfigDataBase.class);

    /**
     * @param connect - link variable to object of class Connection.
     */
    private Connection connect = null;

    /**
     * searchDataBase - searches database (query sql) NAME_DATA_BASE (base_vacancy). If database base_vacancy exists
     * then method returns true, if database base_vacancy does not exists then method returns false.
     * @return - returns true if database base_vacancy exists, false - does not exists.
     */
    public boolean searchDataBase()  {
        boolean found = false;
        try {
            this.connect = DriverManager.getConnection(URL_BASE_POSTGRES, USER_NAME, PASSWORD);
            Statement statement = this.connect.createStatement();
            ResultSet result = statement.executeQuery(SEARCH_DATA_BASE);
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
        try {
            this.connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
            Statement statement = this.connect.createStatement();
            ResultSet result = statement.executeQuery(SEARCH_TABLE_VACANCY);
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
        this.create(URL_BASE_POSTGRES, CREATE_DATA_BASE);
    }

    /**
     * createTableVacancy - connect to database base_vacancy and creates table vacancy.
     */
    public void createTableVacancy() {
        this.create(URL_BASE_VACANCY, CREATE_TABLE_VACANCY);
    }

    /**
     * create - creates database or table in database.
     * @param urlBase - url base connect.
     * @param query - query sql.
     */
    private void create(String urlBase, String query) {
        try {
            this.connect = DriverManager.getConnection(urlBase, USER_NAME, PASSWORD);
            this.connect.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * close - autoCloseables connect.
     * @throws Exception - exception.
     */
    @Override
    public void close() throws Exception {
        this.connect.close();
        logger.info("config connect close ...");
    }

}