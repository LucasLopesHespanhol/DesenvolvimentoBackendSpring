package com.example.aula1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public ResponseEntity<String> buscarCliente(@RequestParam String nome, @RequestParam String cidade) {

        return ResponseEntity.ok("Buscando cliente: " + nome + " da cidade: " + cidade);
    }
}
