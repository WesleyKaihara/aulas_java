package com.wesley.demo.controller;

import com.wesley.demo.models.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidAttributeValueException;
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
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id) {
        System.out.println(listaProdutos.isEmpty());
        if(listaProdutos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Produto produto = listaProdutos
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if(produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Object> adicionar(@RequestBody Produto produto) {
        try {
            Produto p = new Produto();
            p.setId(this.index);
            p.setDescricao(produto.getDescricao());
            p.setValor(produto.getValor());

            this.index++;
            this.listaProdutos.add(produto);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (InvalidAttributeValueException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Optional<Produto>> atualizar(@RequestBody Produto produtoBody, @PathVariable int id) throws InvalidAttributeValueException {
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
