package com.example.aula04.controller;

import com.example.aula04.dto.CepDTO;
import com.example.aula04.facade.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

    @Autowired
    CepFacade cepFacade;

    @GetMapping(value = "/{cep}")
    public CepDTO getInfo(@PathVariable String cep) {
        return this.cepFacade.getCep(cep);
    }
}
