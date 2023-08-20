package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Entity
@DiscriminatorValue("Motorista")
@NoArgsConstructor
public class Motorista extends Pessoa  {

    @Column(name = "numeroCNH", unique = true)
    private String numeroCNH;


    public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String email, String numeroCNH) {
        super(nome, dataNascimento, cpf, sexo, email);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }
}
