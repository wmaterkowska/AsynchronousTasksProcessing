package com.example.asynchronous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronousTaskProcessingApplication {

	public static void main(String[] args) {

		SpringApplication.run(AsynchronousTaskProcessingApplication.class, args);
	}

}
