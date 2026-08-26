package com.example.DevSpring.Aula03.controller;

import com.example.DevSpring.Aula03.model.Pedido03;
import com.example.DevSpring.Aula03.repository.PedidoRepository03;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/aula03-pedido")
public class PedidoController03 {

    private final PedidoRepository03 pedidoRepository;

    public PedidoController03(PedidoRepository03 pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido03> create(@RequestBody Pedido03 pedido) {
        if (pedido == null) {
            return ResponseEntity.badRequest().build();
        }
        Pedido03 pedidoSalvo = pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Pedido03>> findByData(@RequestParam LocalDate data) {
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(pedidoRepository.findByData(data));
    }
}
