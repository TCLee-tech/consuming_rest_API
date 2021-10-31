package com.linkedin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Profile("!test")
@SpringBootApplication
public class LandonMonitorApplication {
	
	//ObjectMapper is a Class from the Jackson library. It serialises and deserialises JSON
	//Java object to JSON string (serialise) and vice versa.
	//Java objects can be Plain Old Java Objects (POJOs) or from JSON tree model(JsonNode).
	
	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LandonMonitorApplication.class, args);
	}

}
