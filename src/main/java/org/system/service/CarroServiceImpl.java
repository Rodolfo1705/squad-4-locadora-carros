package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Carro;
import org.system.repository.CarroRepository;
import org.system.service.interfaces.CarroService;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro save(Carro carro) {
        try {
            if (carroRepository.existsByPlaca(carro.getPlaca())) {
                throw new IllegalArgumentException("Placa do carro já existente no sistema!");
            }
            if (carroRepository.existsByChassi(carro.getChassi())) {
                throw new IllegalArgumentException("Número de chassi já existente no sistema!");
            }

            return carroRepository.save(carro);
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }
}
