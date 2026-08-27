package com.example.DevSpring.Aula02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula02-venda")
public class VendaController02 {

    @GetMapping("/{id}")
    public ResponseEntity<String> listarVenda(@PathVariable Long id) {
        return ResponseEntity.ok("Buscando Venda Com Id : " + id);
    }

    @PostMapping
    public ResponseEntity<String> criarVenda(@RequestBody String venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda De " + venda + " Realizada Com Sucesso!");
    }

}
