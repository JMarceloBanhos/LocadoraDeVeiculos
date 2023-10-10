package com.jmbb.locadora.locadora.service;

import com.jmbb.locadora.locadora.model.Veiculo;
import com.jmbb.locadora.locadora.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void criarVeiculo(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public ResponseEntity<Veiculo> consultarPorId(Long id) {
        return veiculoRepository.findById(id)
                .map(veiculo -> ResponseEntity.ok().body(veiculo))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Veiculo> alterarPorId(Veiculo veiculo, Long id) {
        return veiculoRepository.findById(id)
                .map(veiculoAtualizado -> {
                    veiculoAtualizado.setAno(veiculo.getAno());
                    veiculoAtualizado.setCategoria(veiculo.getCategoria());
                    Veiculo updated = veiculoRepository.save(veiculoAtualizado);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<Veiculo> apagarPorId(Long id) {
        return veiculoRepository.findById(id)
                .map(veiculoParaApagar -> {
                    veiculoRepository.deleteById(id);
                    return ResponseEntity.ok()
                    .body(veiculoParaApagar);
                }).orElse(ResponseEntity.notFound().build());
    }
}

