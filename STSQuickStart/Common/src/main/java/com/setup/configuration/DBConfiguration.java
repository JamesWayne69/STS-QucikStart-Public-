package com.setup.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.setup.configuration.properties.DBProperties;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfiguration {
	
	@Autowired
	private DBProperties dbProperties;
	
	

    @Bean
    DataSource datasource() {
		HikariDataSource hdk = new HikariDataSource();
		hdk.setJdbcUrl(dbProperties.getUrl());
		//hdk.setUsername(System.getProperty("userName"));
		//hdk.setPassword(System.getProperty("passWord"));
		hdk.setDriverClassName(dbProperties.getDriverClassName());
		hdk.setConnectionTimeout(dbProperties.getHikariCP().getConnectionTimeout());
		hdk.setMinimumIdle(dbProperties.getHikariCP().getMinimumIdle());
		hdk.setMaximumPoolSize(dbProperties.getHikariCP().getMaximumPoolSize());
		hdk.setConnectionTimeout(dbProperties.getHikariCP().getConnectionTimeout());
		
		return hdk;
		
	}
	

}
