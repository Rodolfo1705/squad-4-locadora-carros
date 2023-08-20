package org.system.service.interfaces;

import org.system.entity.ApoliceSeguro;

import java.util.List;

public interface ApolicesService {
    public ApoliceSeguro save(ApoliceSeguro apoliceSeguro);
    public List<ApoliceSeguro> findAll();
}
