package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Acessorio;
import org.system.entity.Carro;
import org.system.entity.ModeloCarro;
import org.system.repository.CarroRepository;
import org.system.service.interfaces.CarroService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro save(Carro carro) {
        try {
            if(!isPlacaMercosulValida(carro.getPlaca()) && !isPlacaComumValida(carro.getPlaca())){
                throw new IllegalArgumentException("Placa do carro inválida!");
            }

            if(!isChassiValido(carro.getChassi())){
                throw new IllegalArgumentException("Chassi do carro inválido!");
            }

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

    private boolean isChassiValido(String chassi) {
        String chassiPadrão = "^[A-HJ-NPR-Z0-9]{17}$";

        return chassi.toUpperCase().matches(chassiPadrão);
    }

    private boolean isPlacaComumValida(String placa) {
        String placaPadrão = "^[A-Z]{3}-?\\d{4}$";
        return placa.toUpperCase().matches(placaPadrão);
    }

    private boolean isPlacaMercosulValida(String placa) {
        String placaPadrão = "^[A-Z]{3}\\d[A-Z]{2}\\d{2}$";
        return placa.toUpperCase().matches(placaPadrão);
    }

    public void saveNewDates(Carro carro){
        try{
            carroRepository.save(carro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Carro> listarCarrosDisponiveis(LocalDate dataInicio, LocalDate dataDevolucao) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        List<Carro> todosCarros = carroRepository.findAll();

        for (Carro carro : todosCarros) {
            if (carro.isDisponivelParaAluguel(dataInicio, dataDevolucao)) {
                carrosDisponiveis.add(carro);
            }
        }

        return carrosDisponiveis;
    }

    public List<Carro> findAll() {
        try {
            return carroRepository.findAll();
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de carros!");
        }
        return null;
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> findByModeloCarro(ModeloCarro modeloCarro){
        return carroRepository.findByModeloCarro(modeloCarro);
    }

    public List<Carro> findByAcessorio(Acessorio acessorio) {
        return carroRepository.findByAcessoriosContaining(acessorio);
    }
}
