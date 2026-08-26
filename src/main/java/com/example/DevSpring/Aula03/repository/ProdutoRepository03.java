package com.example.DevSpring.Aula03.repository;

import com.example.DevSpring.Aula03.model.Produto03;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository03 extends JpaRepository<Produto03, Long> {

    List<Produto03> findByNomeContainingIgnoreCase(String nome); //aula03
}
