package com.AlbertAbuav.DogAndOwner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DogAndOwnerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DogAndOwnerApplication.class, args);
		System.out.println("Ioc Container was loaded!");
	}

	//2:37

}
