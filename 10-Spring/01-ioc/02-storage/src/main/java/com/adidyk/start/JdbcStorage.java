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
        return this.jdbcTemplate.update(ADD_USER, user.getLogin(), user.getName());

    }

    /**
     * searchUserById - searches user in item table in database base_tracker by id (used query sql -> SEARCH_ITEM_BY_ID)
     * and returns item if search result true and returns null if search result false.
     * @param id - id item.
     * @return - returns item if search result true and returns null if search result false.
     */
    @Override
    public User searchUserById(String id) {
        return this.jdbcTemplate.queryForObject(SEARCH_USER_BY_ID, new Object[]{Integer.parseInt(id)},
                new UserRowMapper());
    }

    /**
     * @param user - name.
     * @return - return list.
     */
    @Override
    public List<User> searchUserByName(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_NAME, new Object[] {user.getName()}, new UserRowMapper());
    }

    /**
     *
     * @param user - login.
     * @return - return.
     */
    @Override
    public List<User> searchUserByLogin(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_LOGIN, new Object[] {user.getLogin()}, new UserRowMapper());
    }

    /**
     * @param user - login.
     * @return - list.
     */
    @Override
    public List<User> searchUserByLoginByName(User user) {
        return this.jdbcTemplate.query(SEARCH_USER_BY_LOGIN_BY_NAME, new Object[] {user.getLogin(), user.getName()}, new UserRowMapper());
    }

    /**
     *
     * @param user - user.
     */
    @Override
    public int updateUserById(User user) {
        return this.jdbcTemplate.update(UPDATE_USER_BY_ID, user.getLogin(), user.getName(), Integer.parseInt(user.getId()));
    }

    /**
     *
     * @param id - id.
     */
    @Override
    public int removeUserById(String id) {
        return this.jdbcTemplate.update(REMOVE_USER_BY_ID, Integer.parseInt(id));
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return this.jdbcTemplate.query(GET_ALL_USER, new UserRowMapper());
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