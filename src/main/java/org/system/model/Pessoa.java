package org.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "sexo")
    private Sexo sexo;

    @Column(unique = true)
    private String email;

    public Pessoa(String nome, Date dataNascimento, String cpf, Sexo sexo, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
    }
}
