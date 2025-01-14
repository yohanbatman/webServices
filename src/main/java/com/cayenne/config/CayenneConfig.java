package com.cayenne.config;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CayenneConfig {

	@Bean
	public ServerRuntime serverRuntime() {
		return ServerRuntime.builder()
				.dataSource(DataSourceBuilder.create()
						.url("jdbc:mysql://localhost:3306/cayenne_demo")
						.driverClassName("com.mysql.cj.jdbc.Driver")
						.username("cayenne_user")
						.password("your_password")
						.build())
				.addConfig("cayenne-project.xml")
				.build();
	}

	@Bean
	public ObjectContext objectContext(ServerRuntime serverRuntime) {
		return serverRuntime.newContext();
	}
}