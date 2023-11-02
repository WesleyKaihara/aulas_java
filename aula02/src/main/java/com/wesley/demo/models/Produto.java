package com.wesley.demo.models;

import javax.management.InvalidAttributeValueException;

public class Produto {
    private Long id;
    private String descricao;
    private Double valor;

    public Produto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws InvalidAttributeValueException {
        if(descricao.length() < 5) {
            throw new InvalidAttributeValueException("Descrição precisa ter no minino 5 caracteres!!");
        }
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) throws InvalidAttributeValueException {
        if(valor == null || valor < 0) {
            throw new InvalidAttributeValueException("Valor do Produto é inválido!!");
        }
        this.valor = valor;
    }
}
