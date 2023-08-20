package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Carro;
import org.system.service.CarroServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroServiceImpl carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> carros = carroService.findAll();

            return ResponseEntity.ok(carros);
    }

    //Após a adição das datas
    @GetMapping(value = "/disponiveis")
    public ResponseEntity<List<Carro>> listarCarrosDisponiveis(@RequestParam String dataInicio, @RequestParam String dataDevolucao) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicioParsed = LocalDate.parse(dataInicio, dateFormatter);
        LocalDate dataDevolucaoParsed = LocalDate.parse(dataDevolucao, dateFormatter);

        List<Carro> carrosDisponiveis = carroService.listarCarrosDisponiveis(dataInicioParsed, dataDevolucaoParsed);

        return carrosDisponiveis.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carrosDisponiveis);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        Optional<Carro> carroOptional = carroService.findById(id);

        if (carroOptional.isPresent()) {
            Carro carro = carroOptional.get();
            return ResponseEntity.ok(carro);
        }

        return ResponseEntity.notFound().build();
    }




    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Carro carro) {
        try {
            carroService.save(carro);
            return ResponseEntity.ok("Carro cadastrado com sucesso!");
        } catch (RuntimeException  e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar carro: " + e.getMessage());
        }
    }
}
