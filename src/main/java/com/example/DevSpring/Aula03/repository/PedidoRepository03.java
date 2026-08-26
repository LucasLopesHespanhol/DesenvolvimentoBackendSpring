package com.example.DevSpring.Aula03.repository;

import com.example.DevSpring.Aula03.model.Pedido03;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository03 extends JpaRepository<Pedido03, Long> {

    List<Pedido03> findByData(LocalDate data);
}
