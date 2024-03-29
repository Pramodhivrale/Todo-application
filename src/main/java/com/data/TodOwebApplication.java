package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = "com.Repo")
@EntityScan(basePackages = "com.entity")
public class TodOwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodOwebApplication.class, args);
	}

}
