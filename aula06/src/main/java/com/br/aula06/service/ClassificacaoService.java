package com.br.aula06.service;

import com.br.aula06.model.Classificacao;
import com.br.aula06.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificacaoService {

    @Autowired
    ClassificacaoRepository classificacaoRepository;

    public List<Classificacao> listar() {
        return classificacaoRepository.findAll();
    }

}
