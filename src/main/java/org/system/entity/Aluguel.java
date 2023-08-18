package org.system.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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
    private Date dataEntrega;
    @Column(name = "dataDevolucao")
    private Date dataDevolucao;
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
    @OneToOne
    @PrimaryKeyJoinColumn
    private ApoliceSeguro apoliceSeguro;

    public Aluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, ApoliceSeguro apoliceSeguro) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.apoliceSeguro = apoliceSeguro;
    }
}
