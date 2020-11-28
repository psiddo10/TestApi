package com.example.MongoDemo.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import reactor.core.publisher.Flux;

@Document(collection="mongoData")
public class MongoEntity {
	
	private String symbol;
	
	
	private List<MongoEntityData> data;
//	private double buy;
//	private double sell;
//
//	private double high;
//
//	private double low;
//	private double at;
	
//	public MongoEntity() {
//		this.data=new ArrayList<>();
//	}
	
//	public List<MongoEntityData> getData() {
//		return data;
//	}
//
//	public void setData(List<MongoEntityData> data) {
//		this.data = data;
//	}
	public MongoEntity() {}

	public MongoEntity(String symbol, double buy, double sell, double high, double low, double at) {
		super();
		this.symbol = symbol;
//		this.buy = buy;
//		this.sell = sell;
//		this.high = high;
//		this.low = low;
//		this.at = at;
	}

	public MongoEntity(Flux<MongoEntity> mongo) {
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

//	public double getBuy() {
//		return buy;
//	}
//
//	public void setBuy(double buy) {
//		this.buy = buy;
//	}
//
//	public double getSell() {
//		return sell;
//	}
//
//	public void setSell(double sell) {
//		this.sell = sell;
//	}
//
//	public double getHigh() {
//		return high;
//	}
//
//	public void setHigh(double high) {
//		this.high = high;
//	}
//
//	public double getLow() {
//		return low;
//	}
//
//	public void setLow(double low) {
//		this.low = low;
//	}
//
//	public double getAt() {
//		return at;
//	}
//
//	public void setAt(double at) {
//		this.at = at;
//	}


	
	
	
	
}
