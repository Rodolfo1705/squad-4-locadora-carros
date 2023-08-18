package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Fabricante;
import org.system.repository.FabricanteRepository;

import java.util.List;
@Service
public class FabricanteServiceImpl implements FabricanteService{
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Override
    public Fabricante save(Fabricante fabricante) {
        try {
            return fabricanteRepository.save(fabricante);
        }catch (Exception e){
            System.out.println("Não foi possível salvar fabricante!");
        }
        return null;
    }

    @Override
    public List<Fabricante> findAll() {
        try {
            return fabricanteRepository.findAll();
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de fabricantes!");
        }
        return null;
    }
}
