package com.jmbb.locadora.locadora;

import com.jmbb.locadora.locadora.model.Veiculo;
import com.jmbb.locadora.locadora.repository.VeiculoRepository;
import com.jmbb.locadora.locadora.service.VeiculoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

    @InjectMocks
    VeiculoService veiculoService;

    @Mock
    VeiculoRepository veiculoRepository;

    @Test
    public void deletarVeiculoFalha(){
        Mockito.when(veiculoRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Veiculo> retorno = veiculoService.apagarPorId(1L);

        assert retorno.getStatusCode().equals(HttpStatusCode.valueOf(404));
    }

    @Test
    public void deletarVeiculoSucesso(){

        Veiculo veiculo = new Veiculo();
        Mockito.when(veiculoRepository.findById(1L)).thenReturn(Optional.of(veiculo));

        ResponseEntity<Veiculo> retorno = veiculoService.apagarPorId(1L);

        assert retorno.getStatusCode().equals(HttpStatusCode.valueOf(200));
    }
}
