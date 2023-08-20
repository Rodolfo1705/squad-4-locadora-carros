package org.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "acessorios")
@NoArgsConstructor
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "carros")
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros = new ArrayList<>();

    public Acessorio(Long id, String descricao, List<Carro> carros) {
        this.id = id;
        this.descricao = descricao;
        this.carros = carros;
    }
}
