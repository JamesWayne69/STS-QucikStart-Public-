package com.setup.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DBProperties {
	
	private String url;
    private String driverClassName;
    private HikariProperties hikariCP;


}
