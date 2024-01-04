package com.example.HangmanApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HangmanApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HangmanApiApplication.class, args);
	}

}
