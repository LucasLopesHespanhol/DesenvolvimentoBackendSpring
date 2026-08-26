package com.example.DevSpring.Aula03.controller;

import com.example.DevSpring.Aula03.model.Cliente03;
import com.example.DevSpring.Aula03.repository.ClienteRepository03;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula03-cliente")
public class ClienteController03 {

    private final ClienteRepository03 clienteRepository03;

    public ClienteController03(ClienteRepository03 clienteRepository03) {
        this.clienteRepository03 = clienteRepository03;
    }

    @PostMapping
    public ResponseEntity<Cliente03> criarCliente(@RequestBody Cliente03 cliente) {
        Cliente03 clienteSalvo = clienteRepository03.save(cliente);

        return ResponseEntity.ok().body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente03>> listarTodosClientes() {
        return ResponseEntity.ok().body(clienteRepository03.findAll());
    }
}