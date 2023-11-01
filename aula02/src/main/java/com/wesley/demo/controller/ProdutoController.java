package com.wesley.demo.controller;

import com.wesley.demo.models.Produto;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    private List<Produto> listaProdutos = new ArrayList<>();
    private Long index = Long.valueOf(1);

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return new ResponseEntity<List<Produto>>(this.listaProdutos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id) {
        try {
            Optional<Produto> produto = listaProdutos
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (HttpClientErrorException.NotFound nf) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        produto.setId(this.index);
        this.index++;
        this.listaProdutos.add(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Optional<Produto>> atualizar(@RequestBody Produto produtoBody, @PathVariable int id) {
        Produto produto = listaProdutos
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);

        if (produto != null) {
            produto.setDescricao(produtoBody.getDescricao());
            produto.setValor(produtoBody.getValor());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> remover(@PathVariable int id) {
        Produto produto = listaProdutos
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);

        if (produto != null) {
            listaProdutos.remove(produto);
            return new ResponseEntity<String>("Produto com ID " + id + " removido", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Produto com ID " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
