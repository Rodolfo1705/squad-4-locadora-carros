package org.system.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alugueis")
@Data
@NoArgsConstructor
public class Aluguel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataPedido")
    private Calendar dataPedido;
    @Column(name = "dataEntrega")
    private LocalDate dataEntrega;
    @Column(name = "dataDevolucao")
    private LocalDate dataDevolucao;
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
    @OneToOne
    @JoinColumn(name = "apolice_seguro_id")
    private ApoliceSeguro apoliceSeguro;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    public Aluguel(Calendar dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao, BigDecimal valorTotal, ApoliceSeguro apoliceSeguro) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.apoliceSeguro = apoliceSeguro;
    }
}
