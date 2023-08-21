package org.system.service.interfaces;

import org.system.entity.CarrinhoCompra;
import org.system.entity.Carro;

import java.util.List;

public interface CarrinhoCompraService {
    void save(CarrinhoCompra carrinhoCompra);
    List<CarrinhoCompra> findAll();
    void removerCarro(CarrinhoCompra carrinhoCompra, Carro carro);
}
