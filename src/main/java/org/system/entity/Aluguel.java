package org.system.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "aluguel")
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
    @Column(name = "dataDevolução")
    private Date dataDevolução;
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
    @OneToOne
    @PrimaryKeyJoinColumn
    private ApoliceSeguro apoliceSeguro;

    public Aluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolução, BigDecimal valorTotal, ApoliceSeguro apoliceSeguro) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolução = dataDevolução;
        this.valorTotal = valorTotal;
        this.apoliceSeguro = apoliceSeguro;
    }
}
