package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.system.controller.CarroController;
import org.system.service.CarroServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "carros")
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "placa", unique = true)
    private String placa;
    @Column(name = "chassi", unique = true)
    private String chassi;
    @Column(name = "cor")
    private String cor;
    @Column(name = "valorDiaria")
    private BigDecimal valorDiaria;
    @Column(name = "acessorios")
    @ManyToMany
    private List<Acessorio> acessorios = new ArrayList<>()  ;
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modeloCarro;
    @OneToMany
    private List<Aluguel> alugueis;
    @ElementCollection
    @CollectionTable(name = "carro_datas_ocupadas", joinColumns = @JoinColumn(name = "carro_id"))
    @Column(name = "data_ocupada")
    private List<LocalDate> datasOcupadas = new ArrayList<>();

    public Carro(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria, List<Acessorio> acessorios, ModeloCarro modeloCarro, List<LocalDate> datasOcupadas) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.acessorios = acessorios;
        this.modeloCarro = modeloCarro;
        this.datasOcupadas = datasOcupadas;
    }

    public boolean isDisponivelParaAluguel(LocalDate dataInicio, LocalDate dataDevolucao) {
        for (LocalDate data : datasOcupadas) {
            if (!data.isBefore(dataInicio) && !data.isAfter(dataDevolucao)) {
                return false;
            }
        }

        return true;
    }

    public List<LocalDate> bloquearDatas(LocalDate dataInicio, LocalDate dataDevolucao) {
        LocalDate data = dataInicio;
        while (!data.isAfter(dataDevolucao)) {
            datasOcupadas.add(data);
            data = data.plusDays(1);
        }

        return datasOcupadas;
    }
}
