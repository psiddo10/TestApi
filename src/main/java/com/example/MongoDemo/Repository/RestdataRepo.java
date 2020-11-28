package com.example.MongoDemo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.MongoDemo.Entity.MongoEntityData;

public interface RestdataRepo extends ReactiveMongoRepository<MongoEntityData,Long>{
	
//	Mono<List<MongoEntity>> saveAll(Mono<List<MongoEntity>> mongo);

//	@Bean

}
