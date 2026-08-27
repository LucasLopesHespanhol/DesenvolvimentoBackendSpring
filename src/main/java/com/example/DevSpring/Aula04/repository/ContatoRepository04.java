package com.example.DevSpring.Aula04.repository;

import com.example.DevSpring.Aula04.model.Contato04;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository04 extends JpaRepository<Contato04, Long> {
}
