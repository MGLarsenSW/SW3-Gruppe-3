package com.aau.gr3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class P3Application {

	public static void main(String[] args) {
		SpringApplication.run(P3Application.class, args);
	}

}
