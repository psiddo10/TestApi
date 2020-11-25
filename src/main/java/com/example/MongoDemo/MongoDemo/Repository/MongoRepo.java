package com.example.MongoDemo.MongoDemo.Repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MongoRepo extends MongoRepository<MongoEntity, Integer> {

	Flux<MongoEntity> saveAll(Flux<MongoEntity> file);

	


}
