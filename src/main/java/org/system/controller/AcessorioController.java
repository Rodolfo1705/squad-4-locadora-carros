package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.Acessorio;
import org.system.service.AcessorioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {
    @Autowired
    private AcessorioServiceImpl acessorioService;
    @GetMapping
    public ResponseEntity<List<Acessorio>> getAcessorios(){
        return ResponseEntity.ok(acessorioService.getAcessorios());
    }
}
