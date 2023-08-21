package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.CarrinhoCompra;
import org.system.entity.Carro;
import org.system.entity.Motorista;
import org.system.repository.CarrinhoCompraRepository;
import org.system.service.interfaces.CarrinhoCompraService;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoCompraServiceImpl implements CarrinhoCompraService {
    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    @Override
    public List<CarrinhoCompra> findAll() {
        List<CarrinhoCompra> carrinho = carrinhoCompraRepository.findAll();
        if (carrinho.isEmpty()){return null;}
        return carrinho;
    }

    public void save(CarrinhoCompra carrinhoCompra){
        try{
            carrinhoCompraRepository.save(carrinhoCompra);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addCarros(CarrinhoCompra carrinhoCompra, Carro carro){
        try{
            List<Carro> listaCarros = carrinhoCompra.getListaCarros();
            listaCarros.add(carro);

            carrinhoCompraRepository.save(carrinhoCompra);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public CarrinhoCompra findByMotorista(Motorista motorista) {
        try{
            return carrinhoCompraRepository.findByMotorista(motorista);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
