package org.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "modelos_carro")
@NoArgsConstructor
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany
    private List<Carro> carros;
    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    @JsonBackReference
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
