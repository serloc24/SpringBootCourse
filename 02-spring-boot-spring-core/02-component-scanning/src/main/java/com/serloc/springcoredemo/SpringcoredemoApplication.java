package com.serloc.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Different packages to be considered at build beans
//@SpringBootApplication(scanBasePackages = {"com.serloc.springcoredemo", "com.serloc.util"})

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
