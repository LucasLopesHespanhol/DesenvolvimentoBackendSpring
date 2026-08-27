package com.example.DevSpring.Aula04.controller;

import com.example.DevSpring.Aula04.model.Cliente04;
import com.example.DevSpring.Aula04.model.Contato04;
import com.example.DevSpring.Aula04.repository.ClienteRepository04;
import com.example.DevSpring.Aula04.repository.ContatoRepository04;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aula04-contato")
public class ContatoController04 {

    private final ContatoRepository04 contatoRepository;
    private final ClienteRepository04 clienteRepository;

    public ContatoController04(ContatoRepository04 contatoRepository, ClienteRepository04 clienteRepository) {
        this.contatoRepository = contatoRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Contato04> create(@PathVariable Long id, @RequestBody Contato04 contato04) {
        Optional<Cliente04> checkCliente = clienteRepository.findById(id);
        if (checkCliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Cliente04 cliente = checkCliente.get();
        contato04.setCliente(cliente);

        Contato04 contatoSalvo = contatoRepository.save(contato04);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoSalvo);
    }
}
