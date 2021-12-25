package com.linkedin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@SpringBootApplication
public class FeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

}
