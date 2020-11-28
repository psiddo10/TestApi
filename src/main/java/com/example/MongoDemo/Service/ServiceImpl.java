package com.example.MongoDemo.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.Entity.MongoEntityData;
import com.example.MongoDemo.Repository.RestdataRepo;

import reactor.core.publisher.Flux;

@Service
public class ServiceImpl implements MongoService {

	
	private ScheduledExecutorService executor;
	private ScheduledFuture<?> future;
	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();

	@Autowired
	private RestdataRepo repo;
	



	@Override
	public Flux<MongoEntityData> insertdata() {
		executor = Executors.newSingleThreadScheduledExecutor();
		   
		 
		 future = executor.scheduleAtFixedRate(new Runnable(){

			public void run() {
				Flux<MongoEntityData> file=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityData.class);
			
				repo.saveAll(file);
			
				
			
			}
			 
			 
		 },0,1,TimeUnit.SECONDS);
		return null;
	}




	@Override
	public Flux<MongoEntityData> getdata() {
		
		return repo.findAll();
		
	}







//	@Override
//	public Flux<MongoEntity> getdata() {
//
//		executor = Executors.newSingleThreadScheduledExecutor();
//		   
//		 
//		 future = executor.scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				Flux<MongoEntity> file=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);
//			}
//
//		 },0,1,TimeUnit.MINUTES);
//		
//		return null;
//	}




	
}
