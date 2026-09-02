package com.example.DevSpring.Aula05.controller;

import com.example.DevSpring.Aula05.model.Usuario05;
import com.example.DevSpring.Aula05.service.UsuarioService05;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula05-usuario")
public class UsuarioController05 {

    private final UsuarioService05 usuarioService05;

    public UsuarioController05(UsuarioService05 usuarioService05) {
        this.usuarioService05 = usuarioService05;
    }

    @PostMapping
    public ResponseEntity<Usuario05> save(@RequestBody Usuario05 usuario) {
        Usuario05 novoUsuario = usuarioService05.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
