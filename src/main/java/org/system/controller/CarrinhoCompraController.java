package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.*;
import org.system.entity.dto.AdicionarCarrinhoDTO;
import org.system.entity.dto.DetalhesReservaDTO;
import org.system.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/carrinhos-compra")
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraServiceImpl carrinhoCompraService;
    @Autowired
    private MotoristaServiceImpl motoristaService;
    @Autowired
    private CarroServiceImpl carroService;

    //Consertar Método
    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            List<CarrinhoCompra> carrinhoCompras = carrinhoCompraService.findAll();
            return ResponseEntity.ok(carrinhoCompras);
        }catch (Exception e){
            String errorMessage = "Não foi possível encontrar registros de carros em seu carrinho!";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    //método que lista os carros disponíveis no carrinho do cliente
    @GetMapping(value = "/{email}")
    public ResponseEntity<?> findByMotorista(@PathVariable String email){
        try {
            Motorista motorista = motoristaService.findByEmail(email);
            CarrinhoCompra carrinhoCompra = carrinhoCompraService.findByMotorista(motorista);

            return ResponseEntity.ok(carrinhoCompra.getListaCarros());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar carros no carrinho: " + e.getMessage());
        }
    }

    //Método que pega o email do motorista logado e o id do carro que o cliente quer e adiciona no carrinho
    @PostMapping(value = "/adicionar-carro")
    public ResponseEntity<String> save(@RequestBody AdicionarCarrinhoDTO adicionarCarrinhoDTO){
        try {
            String email = adicionarCarrinhoDTO.getEmail();
            Long id = adicionarCarrinhoDTO.getId();

            Motorista motorista = motoristaService.findByEmail(email);
            CarrinhoCompra carrinhoCompra = carrinhoCompraService.findByMotorista(motorista);
            Carro carro = carroService.findById(id);

            carrinhoCompraService.addCarros(carrinhoCompra, carro);
            return ResponseEntity.ok("Carro adicionado no carrinho com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar carro no carrinho de compras: " + e.getMessage());
        }
    }


    //Na hora da 1ª confirmação, as informações de motorista logado, carro e as datas da reserva são passadas novamente para
    // o sistema. Ao recarregar a página, os detalhes serão mostrados junto as informações do carro para a 2ª confirmação
    @GetMapping(value = "/detalhes-reserva")
    public ResponseEntity<?> listarCarrosDisponiveis(@RequestBody DetalhesReservaDTO detalhesReservaDTO) {
        return ResponseEntity.ok(detalhesReservaDTO);
    }
}
