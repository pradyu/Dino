package com.dino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

import com.dino.service.LocuSearchService;
import com.dino.service.LocuSearchServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan({"com.dino"})
@Import(MongoConfig.class)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
public class ApplicationConfig {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

	@Autowired
	private ObjectMapper objectMapper;

	@Bean(name = "restTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean(name = "locuSearchService")
	public LocuSearchService getLocuSearchService() {
		return new LocuSearchServiceImpl();
	}
}
