package com.example.DevSpring.Aula05.repository;

import com.example.DevSpring.Aula05.model.Usuario05;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository05 extends JpaRepository<Usuario05, Long> {

    boolean existsByEmail(String email);
}
