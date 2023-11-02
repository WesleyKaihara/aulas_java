package com.wesley.demo.controller;

import com.wesley.demo.dtos.UpdateEnderecoDTO;
import com.wesley.demo.models.Endereco;
import com.wesley.demo.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    private EnderecoRepository enderecoRepository = new EnderecoRepository();

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos () {
        return new ResponseEntity<>(enderecoRepository.listar(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarEnderecoPorId (@PathVariable Long id) {
        try {
            Endereco e = enderecoRepository.buscarPorId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
        Endereco e = enderecoRepository.salvar(endereco);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody UpdateEnderecoDTO updateEnderecoDTO) {
        try {
            Endereco e = enderecoRepository.atualizar(id, updateEnderecoDTO);
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        try {
            enderecoRepository.remover(id);
            return new ResponseEntity<>("Endereço com id " + id + " removido" ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
