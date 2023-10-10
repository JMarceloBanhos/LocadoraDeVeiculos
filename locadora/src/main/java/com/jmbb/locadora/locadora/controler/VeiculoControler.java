package com.jmbb.locadora.locadora.controler;

import com.jmbb.locadora.locadora.model.Veiculo;
import com.jmbb.locadora.locadora.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VeiculoControler {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping("/veiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarVeiculo(@RequestBody Veiculo veiculo)
    {
     veiculoService.criarVeiculo(veiculo);
    }

    @GetMapping("/veiculos")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listarTodos()
    {
        return veiculoService.listarTodos();
    }
    @GetMapping("/veiculos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Veiculo> consultarPorId(@PathVariable("id") Long id) {
        return veiculoService.consultarPorId(id);
}
    @PutMapping("/veiculos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Veiculo> alterarPorId(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
        return veiculoService.alterarPorId(veiculo, id);
    }
    @DeleteMapping("/veiculos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Veiculo> apagarPorId(@PathVariable("id") Long id) {
        return veiculoService.apagarPorId(id);
    }

}
