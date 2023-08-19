package org.system.service.interfaces;

import org.system.entity.CarrinhoCompra;

import java.util.List;

public interface CarrinhoCompraService {
    public CarrinhoCompra save(CarrinhoCompra carrinhoCompra);
    public List<CarrinhoCompra> findAll();
    public void remove();
}
