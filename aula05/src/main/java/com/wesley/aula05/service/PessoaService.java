package com.wesley.aula05.service;

import com.wesley.aula05.model.Pessoa;
import com.wesley.aula05.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPesssoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa salvarPesssoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

}
