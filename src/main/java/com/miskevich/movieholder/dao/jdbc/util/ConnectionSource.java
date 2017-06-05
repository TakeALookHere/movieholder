package com.miskevich.movieholder.dao.jdbc.util;

import com.miskevich.movieholder.dao.jdbc.JdbcMovieDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class ConnectionSource {

    private static DataSource dataSource;

    public static synchronized DataSource createConnectionSource(){
        if(null != dataSource){
            return dataSource;
        }

        Properties properties = new Properties();
        try {
            properties.load(JdbcMovieDao.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(properties.getProperty("db.driver"));
        basicDataSource.setUrl(properties.getProperty("db.url"));
        basicDataSource.setUsername(properties.getProperty("db.user"));
        basicDataSource.setPassword(properties.getProperty("db.password"));
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(10);

        dataSource = basicDataSource;
        return dataSource;
    }

}
