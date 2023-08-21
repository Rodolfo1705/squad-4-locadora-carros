package org.system.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.system.entity.Carro;
import org.system.entity.Motorista;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DetalhesReservaDTO implements Serializable {
    private String dataInicio;
    private String dataDevolucao;
    private Carro carro;
    private Motorista motorista;

    public DetalhesReservaDTO(String dataInicio, String dataDevolucao, Carro carro, Motorista motorista) {
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.carro = carro;
        this.motorista = motorista;
    }
}
