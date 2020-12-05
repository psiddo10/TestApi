package com.example.MongoDemo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.MongoDemo.Entity.MongoEntityDataDb;

public interface RestdataRepo extends ReactiveMongoRepository<MongoEntityDataDb,Long>{
	
//	Mono<List<MongoEntity>> saveAll(Mono<List<MongoEntity>> mongo);

//	@Bean

}
