package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Acessorio;
import org.system.service.AcessorioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {
    @Autowired
    private AcessorioServiceImpl acessorioService;
    @GetMapping
    public ResponseEntity<List<Acessorio>> getAcessorios(){
        return ResponseEntity.ok(acessorioService.getAcessorios());
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Acessorio acessorio) {
        try {
            acessorioService.save(acessorio);
            return ResponseEntity.ok("Acessório cadastrado com sucesso!");
        } catch (RuntimeException  e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar acessório: " + e.getMessage());
        }
    }
}
