package org.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "carrinhoCompras")
@NoArgsConstructor
public class CarrinhoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Carro> carros;

    public CarrinhoCompra(Long id, List<Carro> carros) {
        this.id = id;
        this.carros = carros;
    }
}
