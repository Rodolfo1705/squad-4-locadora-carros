package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.model.Motorista;
import org.system.repository.MotoristaRepository;

import java.util.List;

@Service
public class MotoristaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> findAll() {
        List<Motorista> motoristas = motoristaRepository.findAll();
        return motoristas;
    }

    /*public Motorista findByEmail(@PathVariable String email){
        return motoristaRepository.findByEmail(email).get();
    }*/
}
