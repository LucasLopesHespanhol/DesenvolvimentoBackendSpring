package com.example.aula1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @GetMapping("/{id}")
    public ResponseEntity<String> listarVenda(@PathVariable Long id) {
        return ResponseEntity.ok("Buscando Venda Com Id: " + id);
    }

    @PostMapping
    public ResponseEntity<String> criarVenda(@RequestBody String venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda De " + venda + " Realizada Com Sucesso!");
    }

}
