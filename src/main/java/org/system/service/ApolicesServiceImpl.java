package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.ApoliceSeguro;
import org.system.repository.ApolicesRepository;

import java.util.List;

@Service
public class ApolicesServiceImpl {
    @Autowired
    private ApolicesRepository apolicesRepository;
    public List<ApoliceSeguro> findAll() {
        return apolicesRepository.findAll();
    }

    public ApoliceSeguro save(ApoliceSeguro apoliceSeguro) {
        try {
            return apolicesRepository.save(apoliceSeguro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
