package com.example.DevSpring.Aula05.service;

import com.example.DevSpring.Aula05.model.Usuario05;
import com.example.DevSpring.Aula05.repository.UsuarioRepository05;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService05 {

    private final UsuarioRepository05 usuarioRepository05;

    public UsuarioService05(UsuarioRepository05 usuarioRepository05) {
        this.usuarioRepository05 = usuarioRepository05;
    }


    public Usuario05 save(Usuario05 usuario) {
        if (usuario.getEmail().isEmpty() || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email inválido!");
        } else if (usuarioRepository05.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email já está em uso!");
        }

        if (usuario.getNome().isBlank() || usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Usuário ou senha inválidos, preencha todos os campos!");
        }

        String nomeNovo = usuario.getNome();
        usuario.setNome(nomeNovo.toUpperCase());

        return usuarioRepository05.save(usuario);
    }
}