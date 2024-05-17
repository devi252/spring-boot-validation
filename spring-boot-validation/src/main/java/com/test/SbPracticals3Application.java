package com.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbPracticals3Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SbPracticals3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 System.out.println("this is a command line runner method....");
	}
}
