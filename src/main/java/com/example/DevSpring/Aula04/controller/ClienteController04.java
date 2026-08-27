package com.example.DevSpring.Aula04.controller;

import com.example.DevSpring.Aula04.model.Cliente04;
import com.example.DevSpring.Aula04.repository.ClienteRepository04;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula04-cliente")
public class ClienteController04 {

    private final ClienteRepository04 clienteRepository;

    public ClienteController04(ClienteRepository04 clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Cliente04> create(@RequestBody Cliente04 cliente) {
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        Cliente04 clienteSalvo = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente04>> findAll() {
        return ResponseEntity.ok().body(clienteRepository.findAll());
    }
}