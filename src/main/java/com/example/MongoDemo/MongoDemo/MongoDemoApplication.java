package com.example.MongoDemo.MongoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.MongoDemo.MongoDemo.Repository.MongoRepo;

@SpringBootApplication
@EnableMongoRepositories("MongoRepo.class()")
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Bean
	public void Webclient() {
		
	}
	
}
