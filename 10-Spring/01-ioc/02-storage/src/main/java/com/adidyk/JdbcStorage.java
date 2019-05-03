package com.adidyk;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class JdbcStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class JdbcStorage implements StorageDAO {

    /**
     *
     */
    private DataSource dataSource;

    /**
     *
     */
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * add - adds user.
     * @param user - user (link variable to object of class User).
     * @return - returns user.
     */
    public User addUser(User user) {
        String SQL = "INSERT INTO users(login, name) VALUES(?, ?)";
        this.jdbcTemplate.update(SQL, user.getName(), user.getLogin());
        return user;
    }

    /**
     * searchUserById - searches user in item table in database base_tracker by id (used query sql -> SEARCH_ITEM_BY_ID)
     * and returns item if search result true and returns null if search result false.
     * @param id - id item.
     * @return - returns item if search result true and returns null if search result false.
     */
    @Override
    public User searchUserById(String id) {
        String SQL = "SELECT * FROM users WHERE id=?";
        return this.jdbcTemplate.queryForObject(SQL, new Object[] {Integer.parseInt(id)}, new UserRowMapper());
    }

    @Override
    public User updateUserById(String id) {
        return null;
    }

    /**
     *
     * @param id - id.
     */
    @Override
    public void removeUserById(String id) {
        String SQL = "DELETE FROM users WHERE id=?";
        System.out.println(this.jdbcTemplate.update(SQL, Integer.parseInt(id)));
    }

    /**
     *
     */
    private static final class UserRowMapper implements RowMapper<User> {

        /**
         *
         * @param rs - rs.
         * @param i - i.
         * @return
         * @throws SQLException
         */
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            return new User(rs.getString("login"), rs.getString("name"));
        }
    }

}