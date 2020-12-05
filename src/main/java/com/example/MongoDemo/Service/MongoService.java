package com.example.MongoDemo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MongoDemo.Entity.MongoEntityData;
import com.example.MongoDemo.Entity.MongoEntityDataDb;

import reactor.core.publisher.Flux;

@Service
public interface MongoService {
	
	
   public Flux<MongoEntityData> getdata();
   
//   public Flux<MongoEntity> insertdata(MongoEntity user);



public Flux<MongoEntityDataDb> insertdata1();

Flux<MongoEntityDataDb> insertdata() throws InterruptedException;


   
   
}
