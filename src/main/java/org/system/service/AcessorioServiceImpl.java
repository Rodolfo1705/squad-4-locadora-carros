package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Acessorio;
import org.system.repository.AcessorioRepository;
import org.system.service.interfaces.AcessorioService;

import java.util.List;
import java.util.Optional;

@Service
public class AcessorioServiceImpl implements AcessorioService {
    @Autowired
    private AcessorioRepository acessorioRepository;
    @Override
    public List<Acessorio> findAll() {
        return acessorioRepository.findAll();
    }

    public Optional<Acessorio> findById(Long id){
        try{
            return acessorioRepository.findById(id);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Acessorio save(Acessorio acessorio) {
        try {
            return acessorioRepository.save(acessorio);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
