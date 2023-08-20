package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.Aluguel;
import org.system.entity.Carro;
import org.system.service.AluguelServiceImpl;
import org.system.service.CarroServiceImpl;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelServiceImpl aluguelService;
    @Autowired
    private CarroServiceImpl carroService;

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = aluguelService.findAll();

        if (!alugueis.isEmpty()) {
            return ResponseEntity.ok(alugueis);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/pagamento-cartao")
    public String processPayment(@RequestBody Map<String, String> payload) {
        String cardNumber = (payload.get("cardNumber"));
        String expirationDate = payload.get("expirationDate");
        String cvv = payload.get("cvv");

        boolean paymentSuccessful = aluguelService.verifyPayment(cardNumber, expirationDate, cvv);

        if (paymentSuccessful) {
            return "redirect:/resumo-reserva";
        } else {
            return "redirect:/pagamento-falhou";
        }
    }

    //Após a confirmação de aluguel
    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Aluguel aluguel) {
        try {
            //informações para teste de bloqueio

            LocalDate dataInicio = LocalDate.of(2023, 8, 25);
            LocalDate dataFinal = LocalDate.of(2023, 8, 29);

            aluguel.setDataEntrega(dataInicio);
            aluguel.setDataDevolucao(dataFinal);

            aluguelService.save(aluguel);
            return ResponseEntity.ok("Aluguel confirmado!");
        } catch (RuntimeException  e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao confirmar aluguel: " + e.getMessage());
        }
    }
}
