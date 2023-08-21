package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Acessorio;
import org.system.entity.ApoliceSeguro;
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

    @Override
    public Acessorio findById(Long id){
        try{
            Optional<Acessorio> acessorioOptional = acessorioRepository.findById(id);
            if (acessorioOptional.isPresent()){
                Acessorio acessorio = acessorioOptional.get();
                return acessorio;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public Acessorio save(Acessorio acessorio) {
        try {
            return acessorioRepository.save(acessorio);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void remove(Long id){
        try {
            acessorioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover acessório: " + e.getMessage());
        }
    }
}
