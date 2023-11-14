package com.wesley.aula05.service;

import com.wesley.aula05.model.Veiculo;
import com.wesley.aula05.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscaVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculoRepository.delete(veiculo);
    }


}
