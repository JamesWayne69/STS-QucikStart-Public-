package com.setup.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.hikari")
public class HikariProperties {
	
	private int maximumPoolSize;
	private int minimumIdle;
	private int idleTimeout;
	private int connectionTimeout;

}
