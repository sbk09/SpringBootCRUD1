package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EntityScan("com.demo.*")
@EnableJpaRepositories("com.demo.*")
@ComponentScan("com.demo.*")
public class SpringBootCrud1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrud1Application.class, args);
	}

}
