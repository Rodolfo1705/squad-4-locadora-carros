package org.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "aluguel")
@Data
public class Aluguel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolução;
    private BigDecimal valorTotal;
    private ApoliceSeguro apoliceSeguro;

    public Aluguel(){}

    public Aluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolução, BigDecimal valorTotal, ApoliceSeguro apoliceSeguro) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolução = dataDevolução;
        this.valorTotal = valorTotal;
        this.apoliceSeguro = apoliceSeguro;
    }
}
