package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Aluguel;
import org.system.entity.Carro;
import org.system.entity.Motorista;
import org.system.repository.AluguelRepository;
import org.system.service.AluguelService;
import org.system.service.AluguelServiceImpl;
import org.system.service.MotoristaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelServiceImpl aluguelService;

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = aluguelService.findAll();

        if (!alugueis.isEmpty()) {
            return ResponseEntity.ok(alugueis);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Aluguel aluguel) {
        try {
            Aluguel newAluguel = aluguelService.save(aluguel);
            return ResponseEntity.ok("Aluguel cadastrado com sucesso!");
        } catch (RuntimeException  e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar aluguel: " + e.getMessage());
        }
    }
}
