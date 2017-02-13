package ru.msk.tkachenko.dmitry.web.webnote.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

//@Configuration
//@Component
public class DataSourceConfig {
	
	private Environment env;
	
//	@Bean //(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/webnote_db");
//        dataSource.setUsername("root");
//        dataSource.setPassword("good35");
        
        
        
        dataSource.setDriverClassName(env.getProperty("${jdbc.drivers}"));
        dataSource.setUrl(env.getProperty("${jdbc.url}"));
        dataSource.setUsername(env.getProperty("${jdbc.username}"));
        dataSource.setPassword(env.getProperty("${jdbc.password}"));
         
        return dataSource;
    }
}
