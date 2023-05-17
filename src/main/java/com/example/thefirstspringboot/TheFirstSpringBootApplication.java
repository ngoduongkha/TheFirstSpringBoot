package com.example.thefirstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class TheFirstSpringBootApplication {

	public static final Logger log = Logger.getLogger(TheFirstSpringBootApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(TheFirstSpringBootApplication.class, args);
	}
}
