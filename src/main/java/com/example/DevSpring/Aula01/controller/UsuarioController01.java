package com.example.DevSpring.Aula01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula01-usuario")
public class UsuarioController01 {

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id) {

        return "Usuário com ID: "+id;
    }

    @GetMapping("/buscar")
    public String buscarPorNome(@RequestParam String nome, @RequestParam String cidade) {
        return "Buscando usuário com nome: "+nome+" da Cidade: "+cidade;
    }

}
