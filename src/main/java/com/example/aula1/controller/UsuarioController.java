package com.example.aula1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id) {
        return "Usuário com ID: " + id;
    }

    @GetMapping("/buscar")
    public String buscarPorNome(@RequestParam String nome) {
        return "Buscando usuário com nome: " + nome;
    }
}
