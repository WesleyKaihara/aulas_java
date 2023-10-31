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
						   "\nDESCRIÇÃO: " + produto.getDescricao() +
				           "\nVALOR: R$ " + produto.getValor());

		produto.setDescricao("Suco de Laranja");
		produto.setValor(15.99);

		System.out.println("---------------------------");

		System.out.println("ID: " + produto.getId() +
				"\nDESCRIÇÃO: " + produto.getDescricao() +
				"\nVALOR: R$ " + produto.getValor());

	}

}
