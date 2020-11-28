package com.example.MongoDemo.Service;

import org.springframework.stereotype.Service;

import com.example.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.Entity.MongoEntityData;

import reactor.core.publisher.Flux;

@Service
public interface MongoService {
	
	
   public Flux<MongoEntityData> getdata();
   
//   public Flux<MongoEntity> insertdata(MongoEntity user);

   public Flux<MongoEntityData> insertdata();
   
   
}
