package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Acessorio;
import org.system.repository.AcessorioRepository;
import org.system.service.interfaces.AcessorioService;

import java.util.EmptyStackException;
import java.util.List;
@Service
public class AcessorioServiceImpl implements AcessorioService {
    @Autowired
    private AcessorioRepository acessorioRepository;
    @Override
    public List<Acessorio> getAcessorios() {
        return acessorioRepository.findAll();
    }
}
