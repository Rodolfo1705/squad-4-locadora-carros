package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.ModeloCarro;
import org.system.service.ModeloCarroServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/modelos-carro")
public class ModeloCarroController {
    @Autowired
    private ModeloCarroServiceImpl modeloCarroService;

    @GetMapping
    public ResponseEntity<List<ModeloCarro>> findAll(){
        try {
            List<ModeloCarro> modelosCarro = modeloCarroService.findAll();
            return ResponseEntity.ok(modelosCarro);
        }catch (Exception e){
            System.out.println("Não foi possível encontrar modelos de carro!");
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ModeloCarro modeloCarro){
        ModeloCarro newModeloCarro = modeloCarroService.save(modeloCarro);
        return ResponseEntity.ok("Modelo de carro cadastrado com sucesso!");
    }
}
