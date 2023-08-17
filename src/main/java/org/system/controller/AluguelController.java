package org.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.Aluguel;
import org.system.entity.Carro;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    /*@GetMapping
    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = aluguelService.findAll();

        if (!alugueis.isEmpty()) {
            return ResponseEntity.ok(alugueis);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }*/
}
