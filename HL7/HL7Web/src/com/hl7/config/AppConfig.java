package com.hl7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ImportResource({ "classpath:/com/hl7/config/spring-config.xml" })
public class AppConfig {

	@Autowired
	MongoTemplate mongoTemplate;

	
}
