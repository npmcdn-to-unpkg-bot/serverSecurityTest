package com.sebhero;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;

@SpringBootApplication
public class SpringBootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

	@Bean
	public Jongo jongo() {
		DB db;
		try {
			db = new MongoClient("127.0.0.1", 27017).getDB("test");
		} catch (UnknownHostException e) {
			throw new MongoException("Connection error : ", e);
		}
		return new Jongo(db);
	}

	@Bean
	public MongoCollection users() {
		return jongo().getCollection("users");
	}
}
