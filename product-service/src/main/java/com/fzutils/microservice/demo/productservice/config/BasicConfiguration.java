package com.fzutils.microservice.demo.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration {

	@Bean 
	public String getTestBean01() {
		return "This is test bean 01";
	}
}

