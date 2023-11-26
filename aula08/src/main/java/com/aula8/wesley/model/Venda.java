package com.aula8.wesley.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDA_ID")
    private BigDecimal id;

    @OneToMany(mappedBy = "pk.VENDA_ID")
    private List<ItensVenda> itensVendas;
}





