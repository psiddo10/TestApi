package com.example.MongoDemo.MongoDemo.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.MongoDemo.Entity.MongoEntityData;
import com.example.MongoDemo.MongoDemo.Repository.restdataRepo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/restdata")
public class EntityDataController {

	private restdataRepo repo;
	
	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();

	
	@Scheduled(fixedRate=1000)

	@GetMapping("/getdata")
	public Flux<MongoEntityData> getaall(){
		
		return webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityData.class);
		
	}
	
	
	
	@PostMapping("/putdata")
	public Flux<MongoEntityData> postall(){
		
		Flux<MongoEntityData> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityData.class);

		
		
		return repo.saveAll(mongo);
		
	}
	
	
	
}
