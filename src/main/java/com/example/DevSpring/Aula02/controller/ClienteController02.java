package com.example.DevSpring.Aula02.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula02-cliente")
public class ClienteController02 {

    @GetMapping
    public ResponseEntity<String> buscarCliente(@RequestParam String nome, @RequestParam String cidade) {

        return ResponseEntity.ok("Buscando cliente: " + nome + " da cidade: " + cidade);
    }
}
