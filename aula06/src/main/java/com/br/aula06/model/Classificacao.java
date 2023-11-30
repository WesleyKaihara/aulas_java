package com.br.aula06.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Classificacao {
    @Id
    @Column(name = "CODIGO")
    private String id;

    private String descricao;

    @OneToMany(mappedBy = "classificacao")
    @JsonIgnoreProperties({ "classificacao" })
    private List<Produto> produtoList;
}
