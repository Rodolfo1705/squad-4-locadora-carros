package org.system.service;

import org.system.entity.Aluguel;

import java.util.List;

public interface AluguelService {
    public Aluguel save(Aluguel aluguel);
    public List<Aluguel> findAll();
}
