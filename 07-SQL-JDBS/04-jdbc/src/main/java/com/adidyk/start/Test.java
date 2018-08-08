package com.adidyk;

import java.sql.*;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.08.2018.
 * @version 1.0.
 */
class Test {

    /**
     *
     */
    private Connection connection;

    /**
     *
     * @param connection - is connection.
     * @throws SQLException - is SQL exception.
     */
    Test(Connection connection) throws SQLException {
        this.connection = connection;
        this.selectOne();
        System.out.println();
        this.selectSecond();
        System.out.println();
        this.selectThird();
        System.out.println();
        this.insertFirst();
        System.out.println();
        this.selectOne();
        System.out.println();
        this.insertSecond();
        System.out.println();
        this.updateFirst();
        System.out.println();
        this.selectOne();
        System.out.println();
        this.deleteFirst();
        System.out.println();
        this.selectOne();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void selectOne() throws SQLException {
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM item");
        while (rs.next()) {
            System.out.println(String.format("%s  %S", rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void selectSecond() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("SELECT * FROM item WHERE item.id IN (?, ?, ?)");
        st.setInt(1, 1);
        st.setInt(2, 3);
        st.setInt(3, 4);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(String.format("%s  %S", rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void selectThird() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("SELECT * FROM item WHERE item.id = ?");
        st.setInt(1, 20);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(String.format("%s  %S", rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void insertFirst() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("INSERT INTO item(name) VALUES (?)");
        st.setString(1, "Sell TV test 1 dsdasdasdasdasd");
        st.executeUpdate();
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void insertSecond() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("INSERT INTO item(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        st.setString(1, "Insert and get primary key");
        st.executeUpdate();
        ResultSet key = st.getGeneratedKeys();
        if (key.next()) {
            System.out.println(key.getInt("id"));

        }
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void updateFirst() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("UPDATE item SET name = ? WHERE id = ?");
        st.setString(1, "Buy bicycle 3 version");
        st.setInt(2, 2);
        st.executeUpdate();
        st.close();
    }

    /**
     *
     * @throws SQLException - is SQL exception.
     */
    private void deleteFirst() throws SQLException {
        PreparedStatement st = this.connection.prepareStatement("DELETE FROM item WHERE id IN (?, ?)");
        st.setInt(1, 6);
        st.setInt(2, 7);
        st.executeUpdate();
        st.close();
    }






}
