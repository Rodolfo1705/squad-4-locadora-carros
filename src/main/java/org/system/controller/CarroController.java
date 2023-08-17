package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Carro;
import org.system.service.CarroServiceImpl;

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

        if (!carros.isEmpty()) {
            return ResponseEntity.ok(carros);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        Optional<Carro> carroOptional = carroService.findById(id);

        if (carroOptional.isPresent()) {
            Carro carro = carroOptional.get();
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Carro carro) {
        try {
            Carro newCarro = carroService.save(carro);
            return ResponseEntity.ok("Carro cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar carro: " + e.getMessage());
        }
    }
}
