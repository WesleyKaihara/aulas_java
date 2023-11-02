package com.wesley.demo.repository;

import com.wesley.demo.dtos.UpdateEnderecoDTO;
import com.wesley.demo.models.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnderecoRepository {

    private static final List<Endereco> listaEndereco = new ArrayList<>();
    private Long index = 1L;

    public List<Endereco> listar() {
        return this.listaEndereco;
    }

    public Endereco buscarPorId(Long id) throws Exception {
        Endereco e = this.listaEndereco
            .stream()
            .filter(endereco -> Objects.equals(endereco.getId(), id))
            .findFirst()
            .orElse(null);

        if(e == null) {
            throw new Exception("Não foi possível localizar um endereço com id " + id);
        }

        return e;
    }

    public Endereco salvar(Endereco endereco) {
        endereco.setId(index);
        this.listaEndereco.add(endereco);
        index++;
        return endereco;
    }

    public Endereco atualizar(Long id, UpdateEnderecoDTO updateEnderecoDTO) throws Exception {
        Endereco e = this.listaEndereco
            .stream()
            .filter(endereco -> Objects.equals(endereco.getId(), id))
            .findFirst()
            .orElse(null);

        if(e == null) {
            throw new Exception("Não foi possível localizar um endereço com id " + id);
        }

        e.setLocalidade(updateEnderecoDTO.getLocalidade());
        e.setBairro(updateEnderecoDTO.getBairro());
        e.setCEP(updateEnderecoDTO.getCep());
        e.setComplemento(updateEnderecoDTO.getComplemento());
        e.setIBGE(updateEnderecoDTO.getIbge());
        e.setDdd(updateEnderecoDTO.getDdd());
        e.setUF(updateEnderecoDTO.getUf());
        e.setLogradouro(updateEnderecoDTO.getLogradouro());

        return e;
    }

    public void remover(Long id) throws Exception {
        Endereco e = this.listaEndereco
            .stream()
            .filter(endereco -> Objects.equals(endereco.getId(), id))
            .findFirst()
            .orElse(null);

        if(e == null) {
            throw new Exception("Não foi possível localizar um endereço com id " + id);
        }

        this.listaEndereco.remove(e);
    }
}
