package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Entity
@DiscriminatorValue("Motorista")
@NoArgsConstructor
public class Motorista extends Pessoa  {

    @Column(name = "numeroCNH", unique = true)
    private String numeroCNH;
    @OneToOne
    private CarrinhoCompra carrinhoCompra;

    public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String email, String numeroCNH, CarrinhoCompra carrinhoCompra) {
        super(nome, dataNascimento, cpf, sexo, email);
        this.numeroCNH = numeroCNH;
        this.carrinhoCompra = carrinhoCompra;
    }
}
