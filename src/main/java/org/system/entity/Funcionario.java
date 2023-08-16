package org.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@DiscriminatorValue("Funcionario")
public class Funcionario extends Pessoa {
    @Column(name = "matricula", unique = true)
    private String matricula;

    public Funcionario(String nome, Date dataNascimento, String cpf, Sexo sexo, String email) {
        super(nome, dataNascimento, cpf, sexo, email);
    }
}
