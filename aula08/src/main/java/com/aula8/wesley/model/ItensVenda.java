package com.aula8.wesley.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ITENS_VENDA")
public class ItensVenda implements Serializable {

    @EmbeddedId
    private ItemVendasPK itemVendasPK;

    private BigDecimal valor;

    private Integer quantidade;
}
