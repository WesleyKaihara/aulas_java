package com.wesley.demo.repository;

import com.wesley.demo.dtos.UpdatePesssoaDTO;
import com.wesley.demo.models.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PessoaRepository {
    private final List<Pessoa> listaPessoas = new ArrayList<>();
    private Long index = 1L;

    public List<Pessoa> listar() {
        return this.listaPessoas;
    }

    public Pessoa buscarPorId(Long id) throws Exception {
        Pessoa p = this.listaPessoas
            .stream()
            .filter(pessoa -> Objects.equals(pessoa.getId(), id))
            .findFirst()
            .orElse(null);

        if(p == null) {
            throw new Exception("Não foi possível localizar uma pessoa com id " + id);
        }

        return p;
    }

    public Pessoa buscarPorCpf(String cpf) throws Exception {
        Pessoa p = this.listaPessoas
            .stream()
            .filter(pessoa -> Objects.equals(pessoa.getCPF(), cpf))
            .findFirst()
            .orElse(null);

        if(p == null) {
            throw new Exception("Não foi possível localizar uma pessoa com cpf " + cpf);
        }

        return p;
    }

    public Pessoa salvar(Pessoa pessoa){
        pessoa.setId(this.index);
        this.listaPessoas.add(pessoa);
        index++;
        return pessoa;
    }

    public Pessoa atualizar(Long id, UpdatePesssoaDTO updatePesssoaDTO) throws Exception {
        Pessoa p = this.listaPessoas
            .stream()
            .filter(pessoa -> Objects.equals(pessoa.getId(), id))
            .findFirst()
            .orElse(null);

        if(p == null) {
            throw new Exception("Não foi possível localizar uma pessoa com id " + id);
        }

        p.setNome(updatePesssoaDTO.getNome());
        p.setSexo(updatePesssoaDTO.getSexo());

        return p;
    }

    public void remover(Long id) throws Exception {
        Pessoa p = this.listaPessoas
            .stream()
            .filter(pessoa -> Objects.equals(pessoa.getId(), id))
            .findFirst()
            .orElse(null);

        if(p == null) {
            throw new Exception("Não foi possível localizar uma pessoa com id " + id);
        }
        this.listaPessoas.remove(p);
    }

}
