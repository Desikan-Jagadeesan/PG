package com.palani.PoultryAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PoultryAssistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoultryAssistanceApplication.class, args);
	}

}
