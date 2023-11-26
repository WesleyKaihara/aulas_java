package com.aula8.wesley.service;

import com.aula8.wesley.model.Venda;
import com.aula8.wesley.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listar() {
        return vendaRepository.findAll();
    }
}
