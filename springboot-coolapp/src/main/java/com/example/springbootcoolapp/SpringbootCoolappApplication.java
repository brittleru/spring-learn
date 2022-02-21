package com.example.springbootcoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
		scanBasePackages = {
				"com.example.springbootcoolapp",
				// "org.wow.utils",
		}
) // this annotation enables auto configuration, component scanning, additional configuration
public class SpringbootCoolappApplication {

	public static void main(String[] args) {

		// this will create the application context, registers all the beans to the component scanning, and will
		// start the embedded server
		SpringApplication.run(SpringbootCoolappApplication.class, args);
	}

}
