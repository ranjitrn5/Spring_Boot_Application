/*
 * @Bean annotation: tells spring boot that datasource has to be stored as a spring bean opject in spring context
 * @ConfigurationProperties: tells DataSourceBuilder to build connection and pooling properties that prefix with spring.datasource
 * @Primary: tells spring boot to use it as default data source
 * @Flyway: flags our secondary datasource as flyway
 */


package com.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	//Secondary Data Source defined
	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@FlywayDataSource
	public DataSource flywayDataSource(){
		return DataSourceBuilder.create().build();
	}
}
