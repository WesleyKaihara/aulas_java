package com.wesley.aula05.controller;

import com.wesley.aula05.model.Veiculo;
import com.wesley.aula05.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.listarVeiculos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Veiculo>> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> v = veiculoService.buscaVeiculoPorId(id);

        if(v.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(v);
        }
        return ResponseEntity.status(HttpStatus.OK).body(v);
    }

    @PostMapping
    public ResponseEntity<Object> adicionarVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.salvarVeiculo(veiculo));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizarVeiculo(@PathVariable Long id,@RequestBody Veiculo veiculoBody) {
        Optional<Veiculo> v = veiculoService.buscaVeiculoPorId(id);

        if(v.isEmpty()) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado!!");
        }
        Veiculo veiculoAtualizado = v.get();
        veiculoAtualizado.setMarca(veiculoBody.getMarca());
        veiculoAtualizado.setModelo(veiculoBody.getModelo());
        veiculoAtualizado.setCor(veiculoBody.getCor());

        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.salvarVeiculo(veiculoAtualizado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> removerVeiculo(@PathVariable Long id){
        Optional<Veiculo> v = veiculoService.buscaVeiculoPorId(id);

        if(v.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo com id " + id + " não foi encontrado!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Veiculo com id: " + id + " foi removido");
    }

}
