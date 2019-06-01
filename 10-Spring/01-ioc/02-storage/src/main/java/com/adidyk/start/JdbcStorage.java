package com.adidyk.start;

import com.adidyk.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static com.adidyk.constant.Constant.*;

/**
 * Class JdbcStorage defines next method for container of users:
 * addUser, searchUserById,searchUserByName, searchUserByLogin, searchUserByLoginByName updateUserById removeUserById
 * updateUserById, removeUserById, getAllUser.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class JdbcStorage implements StorageDAO {

    /**
     * @param jdbcTemplate - jdbcTemplate (link variable to object of class JdbcTemplate).
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * @param dataSource - dataSource (link variable to object DataSource).
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * addUser - adds new user to users table in database base_storage (used query sql -> ADD_USER).
     * @param user - user (link variable to object of class User).
     */
    public int addUser(User user) {
        return this.jdbcTemplate.update(ADD_USER, user.getLogin(), user.getName());
    }

    /**
     * searchUserById - searches user in user table in database base_storage by id (used query sql -> SEARCH_USER_BY_ID)
     * and returns user if search result true and returns EmptyResultDataAccessException if search result false.
     * @param id - user id.
     * @return - returns user if search result true and returns EmptyResultDataAccessException if search result false.
     */
    @Override
    public User searchUserById(String id) {
        return this.jdbcTemplate.queryForObject(SEARCH_USER_BY_ID, new Object[]{Integer.parseInt(id)},
                new UserRowMapper());
    }

    /**
     * searchUserByName - searches user in user table in database base_storage by name (used query sql ->
     * SEARCH_USER_BY_NAME) and returns list user if search result true or returns null if search result false.
     * @param user - user.
     * @return - returns list user if search result true or returns null if search result false.
     */
    @Override
    public List<User> searchUserByName(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_NAME, new Object[] {user.getName()},
                new UserRowMapper());
    }

    /**
     * searchUserByLogin - searches user in user table in database base_storage by login (used query sql ->
     * SEARCH_USER_BY_LOGIN) and returns list user if search result true or returns null if search result false.
     * @param user - user.
     * @return - returns list user if search result true or returns null if search result false.
     */
    @Override
    public List<User> searchUserByLogin(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_LOGIN, new Object[] {user.getLogin()},
                new UserRowMapper());
    }

    /**
     * searchUserByLoginByName - searches user in user table in database base_storage by login and by name
     * (used query sql -> SEARCH_USER_BY_LOGIN_BY_NAME) and returns list user if search result true or
     * returns null if search result false.
     * @param user - user.
     * @return - returns list user if search result true or returns null if search result false.
     */
    @Override
    public List<User> searchUserByLoginByName(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_LOGIN_BY_NAME, new Object[] {user.getLogin(), user.getName()},
                new UserRowMapper());
    }

    /**
     * updateUserById - updates user in user table in database base_storage by id (used query sql -> UPDATE_USER_BY_ID)
     * and returns "1" if update is true or returns "0" if update is false.
     * @param user - user.
     * @return - returns "1" if update is true or returns "0" if update is false.
     */
    @Override
    public int updateUserById(User user) {
        return this.jdbcTemplate.update(UPDATE_USER_BY_ID, user.getLogin(), user.getName(), Integer.parseInt(user.getId()));
    }

    /**
     * removeUserById - removes user in user table in database base_storage by id (used query sql -> REMOVE_USER_BY_ID)
     * and returns "1" if remove true or returns "0" if remove is false.
     * @param id - user id.
     * @return - returns "1" if remove true or returns "0" if remove is false.
     */
    @Override
    public int removeUserById(String id) {
        return this.jdbcTemplate.update(REMOVE_USER_BY_ID, Integer.parseInt(id));
    }

    /**
     * getAllUser - returns all user from user table from database base_storage (query sql -> GET_ALL_USER).
     * @return - returns all user from user table from database base_storage.
     */
    @Override
    public List<User> getAllUser() {
        return this.jdbcTemplate.query(GET_ALL_USER, new UserRowMapper());
    }

    /**
     * Class UserRowMapper.
     */
    private static final class UserRowMapper implements RowMapper<User> {

        /**
         *
         * @param rs - rs (link variable to object to class ResultSet).
         * @param rowNum - row number.
         * @return - returns user by query sql.
         * @throws SQLException - SQLException.
         */
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("login"), rs.getString("name"));
            user.setId(rs.getString("id"));
            return user;
        }
    }

}