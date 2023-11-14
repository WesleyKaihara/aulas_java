package com.example.aula04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
public class Aula04Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula04Application.class, args);
	}

}
