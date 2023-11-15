package com.wesley.aula05.controller;

import com.wesley.aula05.model.Pessoa;
import com.wesley.aula05.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
public class PesssoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPesssoas());
    }

    @GetMapping(value = "/{pessoaId}")
    public ResponseEntity<Optional<Pessoa>> buscarPessoaPorId(@PathVariable Long pessoaId) {
        Optional<Pessoa> p = pessoaService.buscarPessoaPorId(pessoaId);

        if(p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.salvarPesssoa(pessoa));
    }

    @PutMapping(value = "/{pessoaId}")
    public ResponseEntity<Object> atualizarPessoa(@PathVariable Long pessoaId,@RequestBody Pessoa pessoaAtualizada) {
        Optional<Pessoa> p = pessoaService.buscarPessoaPorId(pessoaId);

        if(p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa com id: " + pessoaId + " não foi encontrada!!");
        }
        Pessoa p1 = p.get();
        p1.setNome(pessoaAtualizada.getNome());
        p1.setCpf(pessoaAtualizada.getCpf());
        p1.setSexo(pessoaAtualizada.getSexo());

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.salvarPesssoa(p1));
    }

    @DeleteMapping(value = "/{pessoaId}")
    public ResponseEntity<Object> removerPessoa(@PathVariable Long pessoaId) {
        Optional<Pessoa> p = pessoaService.buscarPessoaPorId(pessoaId);

        if(p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pesssoa com id: " + pessoaId + " não foi encontrada!!");
        }
        Pessoa p1 = p.get();
        pessoaService.removerPessoa(p1);

        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com id: " + pessoaId + " foi removida!!");
    }

}
