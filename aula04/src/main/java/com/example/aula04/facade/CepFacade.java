package com.example.aula04.facade;

import com.example.aula04.dto.CepDTO;
import com.example.aula04.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CepFacade {

    @Autowired
    CepService cepService;

    public CepDTO getCep(String cep) {
        return cepService.getCep(cep);
    }

}
