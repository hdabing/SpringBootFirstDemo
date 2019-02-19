package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//标注一个主程序类，说明这是一个Spring Boot应用
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
		//启动SpringBoot
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
