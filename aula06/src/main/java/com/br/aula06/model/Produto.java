package com.br.aula06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer id;
    private char tipo;
    private String unidade;
    private BigDecimal quantidade;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CLASSIFICACAO")
    private Classificacao classificacao;
}
