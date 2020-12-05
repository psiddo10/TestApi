package com.example.MongoDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.MongoDemo.Entity.MongoEntityData;
import com.example.MongoDemo.Entity.MongoEntityDataDb;
import com.example.MongoDemo.Repository.RestdataRepo;
import com.example.MongoDemo.Service.MongoService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/restdata")
public class EntityDataController {

	@Autowired
	private MongoService service;
	
	@Autowired
	MongoEntityDataDb entity;
	
	
	@Autowired
	private RestdataRepo repo;
	
	WebClient webClient=WebClient.builder().baseUrl("https://api2.pocketbits.in").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();

	

	
	@GetMapping("/getdata")
	public Flux<MongoEntityData> getaall(){
		
		Flux<MongoEntityData> mongo =webClient.get().uri("api/v1/ticker").retrieve().bodyToFlux(MongoEntityData.class);
		System.out.println("click");
		return mongo;
		
		
	}
	
	@PostMapping("/putdata")
	public Flux<MongoEntityDataDb> postall() throws InterruptedException{
		

		
		return service.insertdata();
		 
		
		
		
	}
//	@Scheduled(fixedRate=2000)
	@PostMapping("/putdata1")
	public Flux<MongoEntityDataDb> postall1() throws InterruptedException{
		

		
		

		return service.insertdata1();}
		
	
	
	@GetMapping("/getdbdata")
	public Flux<MongoEntityDataDb> getall1(){
		
		return repo.findAll();
		
		
		
	}
	
	
}
