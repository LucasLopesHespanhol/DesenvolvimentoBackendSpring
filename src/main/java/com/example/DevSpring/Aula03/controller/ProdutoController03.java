package com.example.DevSpring.Aula03.controller;

import com.example.DevSpring.Aula03.model.Produto03;
import com.example.DevSpring.Aula03.repository.ProdutoRepository03;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula03-produto")
public class ProdutoController03 {

    private final ProdutoRepository03 produtoRepository03;

    public ProdutoController03(ProdutoRepository03 produtoRepository03) {
        this.produtoRepository03 = produtoRepository03;
    }

    @GetMapping
    public ResponseEntity<List<Produto03>> buscar(@RequestParam(required = false) String nome) {
        if (nome == null || nome.isBlank()) {
            return ResponseEntity.ok(produtoRepository03.findAll());
        }

        return ResponseEntity.ok(produtoRepository03.findByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Produto03> cadastrarProduto(@RequestBody Produto03 produto) {
        Produto03 produtoSalvo = produtoRepository03.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}