package com.example.MongoDemo.MongoDemo.Repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntityData;

import reactor.core.publisher.Flux;

public interface restdataRepo extends MongoRepository<MongoEntityData, Integer>{

	@Bean
	Flux<MongoEntityData> saveAll(Flux<MongoEntityData> mongo);

}
