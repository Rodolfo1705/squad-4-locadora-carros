package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.CarrinhoCompra;
import org.system.repository.CarrinhoCompraRepository;

import java.util.List;

@Service
public class CarrinhoCompraServiceImpl {
    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;
    public List<CarrinhoCompra> findAll() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra save(CarrinhoCompra carrinhoCompra) {
        try {
            return carrinhoCompraRepository.save(carrinhoCompra);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
