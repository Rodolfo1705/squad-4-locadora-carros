package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "carros")
@NoArgsConstructor
public class    Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
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
    private List<Acessorio> acessorios = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modeloCarro;
    @OneToMany
    private List<Aluguel> alugueis;

    public Carro(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria, List<Acessorio> acessorios, ModeloCarro modeloCarro) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.acessorios = acessorios;
        this.modeloCarro = modeloCarro;
    }
}
