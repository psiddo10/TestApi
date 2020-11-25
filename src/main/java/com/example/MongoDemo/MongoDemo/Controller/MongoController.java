package com.example.MongoDemo.MongoDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.MongoDemo.Repository.MongoRepo;
import com.example.MongoDemo.MongoDemo.Service.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mongoapi12")
@EnableScheduling

public class MongoController {

	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();


	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private Service service;
	
	
	public MongoController() {}
	
	private MongoRepo mongoRepo; 
	@Autowired
	public MongoController(MongoRepo theMongo) {
		mongoRepo=theMongo;
	}
	

	
	@Scheduled(fixedRate=1000)
	@GetMapping("/getall")
	public Flux<MongoEntity> getaall(){
		
		
		Flux<MongoEntity> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);
		
		return mongo;
		
	}
	
	
	@GetMapping("/getall/{symbol}")
	public Mono<MongoEntity> getaall(@PathVariable String symbol ){
		
		return webClient.get().uri("api/v1/ticker/{symbol}").retrieve().bodyToMono(MongoEntity.class);
		
		
	}
	
	@PostMapping("/getall")
	public Flux<MongoEntity> postall(Flux<MongoEntity> user){
		
		Flux<MongoEntity> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);

		return service.insertdata(user);
		
	}
	
	
}
