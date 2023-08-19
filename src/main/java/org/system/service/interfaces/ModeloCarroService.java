package org.system.service.interfaces;

import org.system.entity.ModeloCarro;

import java.util.List;

public interface ModeloCarroService {
    public ModeloCarro save(ModeloCarro modeloCarro);
    public List<ModeloCarro> findAll();
}
