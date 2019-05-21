package com.adidyk.start;

import com.adidyk.models.User;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Class JdbcStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class JdbcStorage implements StorageDAO {

    /**
     * @param jdbcTemplate - jdbcTemplate.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * @param dataSource - data source.
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * addUser - adds new user to users table in database base_storage.
     * @param user - user (link variable to object of class User).
     */
    public int addUser(User user) {
        String SQL = "INSERT INTO users(login, name) VALUES(?, ?)";
        return this.jdbcTemplate.update(SQL, user.getLogin(), user.getName());

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
        return this.jdbcTemplate.queryForObject(SQL, new Object[]{Integer.parseInt(id)}, new UserRowMapper());
    }

    /**
     * @param user - name.
     * @return - return list.
     */
    @Override
    public List<User> searchUserByName(User user) {
        String SQL = "SELECT * FROM users WHERE name=?";
        return this.jdbcTemplate.query(SQL, new Object[] {user.getName()}, new UserRowMapper());
    }

    /**
     *
     * @param user - login.
     * @return - return.
     */
    @Override
    public List<User> searchUserByLogin(User user) {
        String SQL = "SELECT * FROM users WHERE login=?";
        return this.jdbcTemplate.query(SQL, new Object[] {user.getLogin()}, new UserRowMapper());
    }

    /**
     * @param user - login.
     * @return - list.
     */
    @Override
    public List<User> searchUserByLoginByName(User user) {
        String SQL = "SELECT * FROM users WHERE login=? AND name=?";
        return this.jdbcTemplate.query(SQL, new Object[] {user.getLogin(), user.getName()}, new UserRowMapper());
    }

    /**
     *
     * @param user - user.
     */
    @Override
    public int updateUserById(User user) {
        String SQL = "UPDATE users SET login = ?, name = ? WHERE id = ?";
        return this.jdbcTemplate.update(SQL, user.getLogin(), user.getName(), Integer.parseInt(user.getId()));
    }

    /**
     *
     * @param id - id.
     */
    @Override
    public int removeUserById(String id) {
        String SQL = "DELETE FROM users WHERE id=?";
        return this.jdbcTemplate.update(SQL, Integer.parseInt(id));
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> getAllUser() {
        String SQL = "SELECT * FROM users ORDER BY id";
        return this.jdbcTemplate.query(SQL, new UserRowMapper());
    }



    /**
     *
     */
    private static final class UserRowMapper implements RowMapper<User> {

        /**
         *
         * @param rs - rs.
         * @param rowNum - i.
         * @return
         * @throws SQLException
         */
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("login"), rs.getString("name"));
            user.setId(rs.getString("id"));
            return user;
        }
    }

}