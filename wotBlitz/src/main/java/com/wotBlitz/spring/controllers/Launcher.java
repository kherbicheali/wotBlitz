package com.wotBlitz.spring.controllers;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {
	
	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
	
	public static void main (String[] args) {
		logger.info("-- main()");
		SpringApplication.run(Launcher.class, args);
		
	}
}	
