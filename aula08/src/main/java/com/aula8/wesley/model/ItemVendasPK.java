package com.aula8.wesley.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ItemVendasPK implements Serializable {
    @JoinColumn(name = "VENDA_ID")
    @ManyToOne()
    @JsonIgnore
    private Venda venda;

    @JoinColumn(name = "PRODUTO_ID")
    @ManyToOne()
    @JsonIgnore
    private Produto produto;
}
