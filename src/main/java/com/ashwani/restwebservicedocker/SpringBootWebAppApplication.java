package com.ashwani.restwebservicedocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootWebAppApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(SpringBootWebAppApplication.class);
	public static void main(String[] args) {
		LOGGER.info("SpringBootWebAppApplication  Applicatis is started...");
		SpringApplication.run(SpringBootWebAppApplication.class, args);
	}

}
