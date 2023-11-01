package com.wesley.demo;

import com.wesley.demo.models.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Aula 02");

//		List<Produto> listaProdutos = new ArrayList<>();
//		listaProdutos.add(null);
//
//		for(int i=0; i < 9 ; i++) {
//			var p = new Produto();
//			p.setId(Long.valueOf(1+ i));
//			p.setDescricao("teste" + i);
//			p.setValor(29.9 + i);
//			listaProdutos.add(p);
//		}
//
//		for (Produto produto: listaProdutos) {
//			if(produto != null) {
//				System.out.println(produto.getDescricao());
//			}
//		}

//		listaProdutos.forEach(produto -> {
//			if(produto != null) {  //isPresent()
//				System.out.println(produto.getDescricao());
//			}
//		});
//


	}

}
