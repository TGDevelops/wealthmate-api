package com.tgdevelops.wealthmate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WealthmateApplication {
	private static final Logger log = LogManager.getLogger(WealthmateApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WealthmateApplication.class, args);
	}

}
