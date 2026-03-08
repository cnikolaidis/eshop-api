package com.iekakmi.eshop_api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * @SpringBootApplication Annotation signifies the starting point of
 * a Spring Boot application. Every piece of code will be scanned
 * starting from this class.
 */
@SpringBootApplication
public class EshopApiApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EshopApiApplication.class, args);
	}
}
