package com.example.aula1.controller;

import com.example.aula1.model.Cliente;
import com.example.aula1.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/aula02")
    public ResponseEntity<String> buscarCliente(@RequestParam String nome, @RequestParam String cidade) {

        return ResponseEntity.ok("Buscando cliente: " + nome + " da cidade: " + cidade);
    }

    @PostMapping("/aula03")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);

        return ResponseEntity.ok().body(clienteSalvo);
    }

    @GetMapping("/aula03")
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        return ResponseEntity.ok().body(clienteRepository.findAll());
    }
}
