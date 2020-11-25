package com.example.MongoDemo.MongoDemo.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.MongoDemo.Repository.MongoRepo;

import reactor.core.publisher.Flux;

public class ServiceImpl implements Service {

	
	private ScheduledExecutorService executor;
	private ScheduledFuture<?> future;
	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();

	@Autowired
	private MongoRepo mongoRepo;
	
	

	



	@Override
	public Flux<MongoEntity> insertdata(Flux<MongoEntity> user) {
		executor = Executors.newSingleThreadScheduledExecutor();
		   
		 
		 future = executor.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				Flux<MongoEntity> file=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);
			
				mongoRepo.saveAll(file);
			
			
			}
			 
			 
		 },0,1,TimeUnit.MINUTES);
		return null;
	}







	@Override
	public Flux<MongoEntity> getdata() {
		// TODO Auto-generated method stub
		return null;
	}

}
