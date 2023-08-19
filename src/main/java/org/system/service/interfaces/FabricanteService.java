package org.system.service.interfaces;

import org.system.entity.Fabricante;

import java.util.List;

public interface FabricanteService {
    public Fabricante save(Fabricante fabricante);
    public List<Fabricante> findAll();
}
