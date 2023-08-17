package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "modelo")
@NoArgsConstructor
public class ModeloCarro {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany
    private List<Carro> carros;
    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;
    @Column(name = "categoria")
    private Categoria categoria;

    public ModeloCarro(Long id, String descricao, List<Carro> carros, Fabricante fabricante, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.carros = carros;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }
}
