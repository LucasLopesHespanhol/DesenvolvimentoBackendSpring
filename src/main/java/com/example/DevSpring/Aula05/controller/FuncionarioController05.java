package com.example.DevSpring.Aula05.controller;

import com.example.DevSpring.Aula05.model.Funcionario05;
import com.example.DevSpring.Aula05.service.FuncionarioService05;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aula05-funcionario")
public class FuncionarioController05 {

    private final FuncionarioService05 funcionarioService05;

    public FuncionarioController05(FuncionarioService05 funcionarioService05) {
        this.funcionarioService05 = funcionarioService05;
    }

    @PostMapping
    public ResponseEntity<Funcionario05> save(@RequestBody Funcionario05 funcionario) {
        Funcionario05 f = funcionarioService05.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(f);
    }

    @PostMapping("/lote")
    public ResponseEntity<List<Funcionario05>> saveList(@RequestBody List<Funcionario05> funcionarios) {
        List<Funcionario05> salvos = funcionarioService05.saveAll(funcionarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }
}
