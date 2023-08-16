package org.system.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable; //Permite que o objeto vire uma cadeia de bits para trafegar na rede/savar em arquivos
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "motorista")
@Data
public class Motorista extends Pessoa implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCNH;

    public Motorista(){}

    public Motorista(String nome, Date dataNascimento, String cpf, Sexo sexo, String email, String numeroCNH) {
        super(nome, dataNascimento, cpf, sexo, email);
        this.numeroCNH = numeroCNH;
    }
}
