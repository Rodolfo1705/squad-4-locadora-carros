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

    /*@GetMapping(value = "/{email}")
    public Motorista findByEmail(@PathVariable String email) {
        Motorista motorista = motoristaService.findByEmail().get();
        return motorista;
    }
*/

    //new Motorista("Maria", data, "02103205422", Sexo.FEMININO, "maria@gmail.com", "032555");
    /*public ResponseEntity<List<Motorista>> findAll() {
        List<Motorista> motoristas = motoristaService.findAll();
        return ResponseEntity.ok().body(motoristas);
    }*/
}
