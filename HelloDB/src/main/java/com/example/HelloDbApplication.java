package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.DBController;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HelloDbApplication {

	public static void main(String[] args) {
		log.info("DB");
		DBController db=new DBController();
		db.insertTest();
		SpringApplication.run(HelloDbApplication.class, args);
	}

}
