package com.wesley.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private Long id;
    private String nome;
    private String CPF;
    private char sexo;
    private LocalDate dataNascimento;

    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void addEndereco(Endereco endereco) throws Exception {
        Endereco e = listaEnderecos
            .stream()
            .filter(end -> Objects.equals(end.getId(), endereco.getId()))
            .findFirst()
            .orElse(null);

        if(e != null) {
            throw new Exception("Endereço já esta registrado para usuário " + this.getId());
        }

        listaEnderecos.add(endereco);
    }

    public  List<Endereco> getListaEnderecos() {
        return this.listaEnderecos;
    }
}
