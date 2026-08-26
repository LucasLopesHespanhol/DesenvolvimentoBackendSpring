package com.example.DevSpring.Aula02.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula02-pedido")
public class PedidoController {

    @GetMapping
    public ResponseEntity<String> listarPedidos() {
       return ResponseEntity.ok("Listando Todos Os Pedidos");
    }

    @PostMapping
    public ResponseEntity<String> postarPedido(@RequestBody String pedido) {
        return ResponseEntity.ok("Pedido Postado: " + pedido);

    }

}
