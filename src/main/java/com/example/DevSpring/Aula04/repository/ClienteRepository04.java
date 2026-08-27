package com.example.DevSpring.Aula04.repository;

import com.example.DevSpring.Aula04.model.Cliente04;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository04 extends JpaRepository<Cliente04, Long> {
}
