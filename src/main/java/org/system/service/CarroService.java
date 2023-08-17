package org.system.service;

import org.system.entity.Carro;

import java.util.List;

public interface CarroService {
    public Carro save(Carro carro);
    public List<Carro> findAll();

}
