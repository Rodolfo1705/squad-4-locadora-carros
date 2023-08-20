package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Motorista;
import org.system.service.MotoristaServiceImpl;
import java.util.List;

@RestController // métodos deste controlador retornarão objetos que serão serializados em JSON e enviados como resposta HTTP.
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaServiceImpl motoristaService;

    @GetMapping
    public List<Motorista> findAll() {
        List<Motorista> motoristas = motoristaService.findAll();
        return motoristas;
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Motorista motorista) {
        try {
            Motorista newMotorista = motoristaService.save(motorista);
            return ResponseEntity.ok("Motorista cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar motorista: " + e.getMessage());
        }
    }

   @GetMapping(value = "/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Motorista motorista = motoristaService.findByEmail(email);

        if (motorista == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado!");
        } else {
            return ResponseEntity.ok(motorista);
        }
    }
}
