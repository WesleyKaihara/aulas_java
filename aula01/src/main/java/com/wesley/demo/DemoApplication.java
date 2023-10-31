package com.wesley.demo;

import models.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		var produto = new Produto(123, "Suco", 12.50);
		System.out.println("ID: " + produto.getId() +
						   "\nNOME PRODUTO: " + produto.getNome() +
				           "\nVALOR: R$ " + produto.getValor());
	}

}
