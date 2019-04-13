package com.adidyk;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

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
    public User add(User user) {
        System.out.println("jdbcTemlate update");
        String sql = "INSERT INTO users(login, name) VALUES('temp', 'temp')";
        System.out.println("jdbcTemlate update");
        this.jdbcTemplate.update(sql);
        return user;
    }



}