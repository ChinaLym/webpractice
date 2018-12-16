package com.edeclare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class EdeclareApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdeclareApplication.class, args);
	}
	
}
