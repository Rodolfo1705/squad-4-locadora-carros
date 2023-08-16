package org.system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.model.Aluguel;
import org.system.model.ApoliceSeguro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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
