package com.aau.gr3;

import com.aau.gr3.util.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class P3Application {

	public static void main(String[] args) {
		SpringApplication.run(P3Application.class, args);

		// Try to establish a connection to the database
		// Close the connection when the application is closed
		try {
			Connection.establish();
			Runtime.getRuntime().addShutdownHook(new Thread(() -> Connection.close()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
