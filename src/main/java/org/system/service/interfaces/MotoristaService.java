package org.system.service.interfaces;

import org.system.entity.Motorista;

import java.util.List;

public interface MotoristaService {
    public List<Motorista> findAll();
    public Motorista save(Motorista motorista);
}
