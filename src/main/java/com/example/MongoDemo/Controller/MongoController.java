package com.example.MongoDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.Entity.MongoEntity;
import com.example.MongoDemo.Repository.MongoRepo;
import com.example.MongoDemo.Service.MongoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mongoapi12")
public class MongoController {

	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();


	
//	@Autowired
//	private MongoService service;
//	
//	public MongoController(MongoService theService) {
//		service=theService;
//	}
//	
//	public MongoRepo mongoRepo;
//	@Autowired
//	public MongoController(MongoRepo theMongoRepo) {
//		mongoRepo=theMongoRepo;
//	}
//	
//	


	
	@GetMapping("/getall")
	public Flux<MongoEntity> getaall(){
		
		
		Flux<MongoEntity> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);
		
		
		
		return mongo;
		
	}
	
	
//	@GetMapping("/getall1")
//	public List<MongoEntity> getaall1(){
//		
//		return mongoRepo.findAll();
//		
//	}
//	
//	@PostMapping("/getall")
//	public Flux<MongoEntity> postall(Flux<MongoEntity> user){
//		
//		Flux<MongoEntity> mongo=webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntity.class);
////		
////		
////		
//	
//		return mongoRepo.saveAll(mongo);
//		
//	}	
	
}
