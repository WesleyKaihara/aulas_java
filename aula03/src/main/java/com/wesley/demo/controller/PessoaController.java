package com.wesley.demo.controller;

import com.wesley.demo.dtos.EnderecoPessoaDTO;
import com.wesley.demo.dtos.UpdatePesssoaDTO;
import com.wesley.demo.models.Endereco;
import com.wesley.demo.models.Pessoa;
import com.wesley.demo.repository.EnderecoRepository;
import com.wesley.demo.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    private List<Pessoa> listaPessoas = new ArrayList<>();

    private final PessoaRepository pessoaRepository = new PessoaRepository();
    private final EnderecoRepository enderecoRepository = new EnderecoRepository();

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return new ResponseEntity<>(pessoaRepository.listar(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable Long id ) {
        try {
            Pessoa p = pessoaRepository.buscarPorId(id);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Object> getPessoa(@PathVariable(value = "cpf") String cpf ) {
        try {
            Pessoa p = pessoaRepository.buscarPorCpf(cpf);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        Pessoa p = pessoaRepository.salvar(pessoa);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PostMapping(value = "/endereco")
    public ResponseEntity<Object> adicionarEndereco(@RequestBody EnderecoPessoaDTO enderecoPessoaDTO) {

        try {
            Pessoa p = pessoaRepository.buscarPorId(enderecoPessoaDTO.getPessoaId());
            Endereco e = enderecoRepository.buscarPorId(enderecoPessoaDTO.getEnderecoId());

            p.addEndereco(e);
            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody UpdatePesssoaDTO updatePesssoaDTO) {
        try {
            Pessoa p = pessoaRepository.atualizar(id, updatePesssoaDTO);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        try {
            pessoaRepository.remover(id);
            return new ResponseEntity<>("Pessoa com id " + id + " foi removida!!",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
