package com.virtualcommerce.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/virtualcommerce");
		SpringApplication.run(BackendApplication.class, args);
	}
	
}
