package com.cosmos.cosmos;

import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CosmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

}

