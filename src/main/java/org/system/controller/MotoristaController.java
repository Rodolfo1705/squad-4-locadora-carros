package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.system.model.Motorista;
import org.system.service.MotoristaService;
import java.util.List;

@RestController // métodos deste controlador retornarão objetos que serão serializados em JSON e enviados como resposta HTTP.
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public List<Motorista> findAll() {
        List<Motorista> motoristas = motoristaService.findAll();
        return motoristas;
    }

    /*@GetMapping(value = "/{email}")
    public Motorista findByEmail(@PathVariable String email) {
        Motorista motorista = motoristaService.findByEmail().get();
        return motorista;
    }

    @PostMapping
    public Motorista insert(@RequestBody Motorista motorista) {
        Motorista newMotorista = motoristaService.save(motorista);
        return newMotorista;
    }*/

    //new Motorista("Maria", data, "02103205422", Sexo.FEMININO, "maria@gmail.com", "032555");
    /*public ResponseEntity<List<Motorista>> findAll() {
        List<Motorista> motoristas = motoristaService.findAll();
        return ResponseEntity.ok().body(motoristas);
    }*/
}
