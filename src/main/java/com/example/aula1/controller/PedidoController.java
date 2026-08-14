package com.example.aula1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping
    public ResponseEntity<String> listarPedidos() {
       return ResponseEntity.ok("Listando Todos Os Produtos");
    }

    @PostMapping
    public ResponseEntity<String> postarPedido(@RequestBody String pedido) {
        return ResponseEntity.ok("Pedido Postado: " + pedido);

    }

}
