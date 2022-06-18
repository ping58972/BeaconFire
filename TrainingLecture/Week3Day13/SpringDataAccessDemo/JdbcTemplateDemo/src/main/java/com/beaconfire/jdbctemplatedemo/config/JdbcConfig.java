package com.beaconfire.jdbctemplatedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

//    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final String DB_URL = "jdbc:mysql://beaconfiretraining.cvjh8ezt6tlh.us-east-1.rds.amazonaws.com/JavaBackendTraining";
//    private final String USER = "admin";
//    private final String PASSWORD = "Beaconfire#2022";
//
//    @Bean
//    public DataSource jdbcDataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(JDBC_DRIVER);
//        dataSource.setUrl(DB_URL);
//        dataSource.setUsername(USER);
//        dataSource.setPassword(PASSWORD);
//        return dataSource;
//    }
}
