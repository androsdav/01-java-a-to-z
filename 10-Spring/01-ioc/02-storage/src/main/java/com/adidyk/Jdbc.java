package com.adidyk;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Jdbc {

    /**
     *
     */
    private DataSource dataSource;

    /**
     *
     */
    private JdbcTemplate jdbcTemplate;

    /**
     *
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



}
