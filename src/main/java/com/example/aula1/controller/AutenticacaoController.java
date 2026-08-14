package com.example.aula1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha){
        if (senha.isEmpty() || usuario.isEmpty() || senha.isBlank() || usuario.isBlank()) {
            return ResponseEntity.badRequest().body("Usuario ou senha incorretos ou vazios!");
        }

        String json = """
                {
                    "mensagem": "Login efetuado com sucesso!",
                    "token": "abc123"
                }
                """;

        return ResponseEntity.ok().body(json);
    }
}
