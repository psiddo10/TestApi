package com.example.MongoDemo.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.Entity.MongoEntityData;
import com.example.MongoDemo.Entity.MongoEntityDataDb;
import com.example.MongoDemo.Repository.RestdataRepo;

import reactor.core.publisher.Flux;

@Service
@EnableScheduling
public class ServiceImpl implements MongoService {

	boolean t=true;
	
	private ScheduledExecutorService executor;
	private ScheduledFuture<?> future;
	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	
	@Autowired
	private RestdataRepo repo;
	
	@Autowired
	MongoEntityDataDb data;

	Flux<MongoEntityDataDb> file=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityDataDb.class);
	
	@Override
	public Flux<MongoEntityData> getdata() {
		
		Flux<MongoEntityData> mongo =webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityData.class);
		
		
		return mongo;
		
		
	}
	
	
	@Override
	public Flux<MongoEntityDataDb> insertdata() throws InterruptedException {
		
		
		
		
		
		
		System.out.println("hello");
		
		
		Flux<MongoEntityDataDb> mongo =webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityDataDb.class);
		
		 repo.saveAll(mongo);
		
		return null;
		
		
	}

	
	
	@Override
	public Flux<MongoEntityDataDb> insertdata1() {
		executor = Executors.newSingleThreadScheduledExecutor();
		   
		 
		 future = executor.scheduleAtFixedRate(new Runnable(){


			 @Override
			public void run() {
				 
				
				 
				 Flux<MongoEntityDataDb> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityDataDb.class);
				 
				
				repo.saveAll(mongo);
				
				System.out.println("working"); 
				 
				
			 
			}
			 },0,2,TimeUnit.SECONDS);
		
		 return null; 
		
	}



//	@Override
//	public Flux<MongoEntityDataDb> insertdata() throws InterruptedException {
//		 Flux<MongoEntityDataDb> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityDataDb.class);
//		
//		 
//		repo.saveAll(mongo);
//		 
//		return mongo;
//		 
//		
//	}

	

	

}











//	@Override
//	public Flux<MongoEntityData> getdata() {
//		
//		return repo.findAll();
//		
//	}



	







	

