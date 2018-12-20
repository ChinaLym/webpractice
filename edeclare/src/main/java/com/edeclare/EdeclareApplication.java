package com.edeclare;

import java.util.TimeZone;

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
		//设置时区,出现时区乱码问题则使用 SET GLOBAL time_zone='+8:00';
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(EdeclareApplication.class, args);
	}
	
}
