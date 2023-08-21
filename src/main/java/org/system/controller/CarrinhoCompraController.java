package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.system.entity.CarrinhoCompra;
import org.system.entity.Carro;
import org.system.entity.Fabricante;
import org.system.entity.Motorista;
import org.system.service.CarrinhoCompraServiceImpl;
import org.system.service.CarroServiceImpl;
import org.system.service.ModeloCarroServiceImpl;
import org.system.service.MotoristaServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinhos-compra")
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraServiceImpl carrinhoCompraService;
    @Autowired
    private MotoristaServiceImpl motoristaService;
    @Autowired
    private CarroServiceImpl carroService;

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
    /*
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Carro carro, @RequestParam String email){
        try {
            Motorista motorista = motoristaService.findByEmail(email);
            CarrinhoCompra carrinhoCompra = carrinhoCompraService.findByMotorista(motorista);

            carrinhoCompraService.addCarros(carrinhoCompra, carro);
            return ResponseEntity.ok("Carro adicionado no carrinho com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar carro no carrinho de compras: " + e.getMessage());
        }
    }
     */
}
