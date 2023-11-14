package com.example.aula04.service;

import com.example.aula04.dto.CepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "cep")
public interface CepService {
    @GetMapping(value = "/{cep}/json")
    CepDTO getCep(@PathVariable String cep);
}
