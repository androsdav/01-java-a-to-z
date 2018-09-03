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
     * @throws ClassNotFoundException - is.
     * @throws SQLException - is.
     * @return true or false.
     */
    public boolean searchDataBase() throws ClassNotFoundException, SQLException {
        boolean result = false;
        Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(SEARCH_DATA_BASE);
        while (rs.next()) {
            if ("base_tracker_1".equals(rs.getString("datname"))) {
                result = true;
            }
        }
        rs.close();
        st.close();
        connect.close();
        return result;
    }

    /**
     *
     * @throws SQLException - is exception.
     */
    public void createDataBase() throws SQLException {
        Connection connect = DriverManager.getConnection(URL_BASE_POSTGRES, NAME, PASSWORD);
        //System.out.println("new_base_2 create ...");
        connect.createStatement().executeUpdate(CREATE_DATA_BASE);
        connect.close();
    }

}