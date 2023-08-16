package org.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

   /*@GetMapping
    public ResponseEntity<Aluguel> listarAlugueis(){
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        Date date = new Date();
        Aluguel aluguel = new Aluguel(calendar, date, date, 2.5, apoliceSeguro);
        return ResponseEntity.ok().body(aluguel);
    }*/
}
