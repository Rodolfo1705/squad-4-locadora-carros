package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Fabricante;
import org.system.service.interfaces.FabricanteService;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll(){
        try {
            List<Fabricante> fabricantes = fabricanteService.findAll();
            return ResponseEntity.ok(fabricantes);
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de fabricantes!");
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Fabricante fabricante){
        Fabricante newFabricante = fabricanteService.save(fabricante);
        return ResponseEntity.ok("Fabricante cadastrado com sucesso!");
    }
}
