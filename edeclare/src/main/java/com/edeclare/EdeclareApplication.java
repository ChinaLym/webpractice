package com.edeclare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
* Type: EdeclareApplication
* Description: 启动类
* @author LYM
* @date Dec 18, 2018
 */
@ServletComponentScan
@SpringBootApplication
public class EdeclareApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdeclareApplication.class, args);
	}
	
}
