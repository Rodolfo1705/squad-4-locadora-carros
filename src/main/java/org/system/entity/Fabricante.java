package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "fabricante")
@NoArgsConstructor
public class Fabricante {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "fabricante")
    private List<ModeloCarro> modeloCarros;

    public Fabricante(Long id, String nome, List<ModeloCarro> modeloCarros) {
        this.id = id;
        this.nome = nome;
        this.modeloCarros = modeloCarros;
    }
}
