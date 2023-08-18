package org.system.service;

import org.springframework.stereotype.Service;
import org.system.entity.Aluguel;

import java.util.List;

public interface AluguelService {
    public Aluguel save(Aluguel aluguel);
    public List<Aluguel> findAll();
}
