package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "carros")
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
    private List<Acessorio> acessorios = new ArrayList<>();
}
