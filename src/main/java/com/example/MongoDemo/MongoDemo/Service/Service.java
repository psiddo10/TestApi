package com.example.MongoDemo.MongoDemo.Service;

import java.util.List;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntity;

import reactor.core.publisher.Flux;

public interface Service {
	
	
   public Flux<MongoEntity> getdata();
   
//   public Flux<MongoEntity> insertdata(MongoEntity user);

public Flux<MongoEntity> insertdata(Flux<MongoEntity> user);
   
   
}
