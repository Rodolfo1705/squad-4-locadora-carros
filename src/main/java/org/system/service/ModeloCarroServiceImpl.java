package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.ModeloCarro;
import org.system.repository.ModeloCarroRepository;

import java.util.List;

@Service
public class ModeloCarroServiceImpl implements ModeloCarroService{
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Override
    public ModeloCarro save(ModeloCarro modeloCarro) {
        try {
            return modeloCarroRepository.save(modeloCarro);
        }catch (Exception e){
            System.out.println("Não foi possível salvar modelo de carro!");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ModeloCarro> findAll() {
        try {
            return modeloCarroRepository.findAll();
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de modelos de carro!");
        }
        return null;
    }
}
