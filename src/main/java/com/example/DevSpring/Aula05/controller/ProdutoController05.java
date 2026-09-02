package com.example.DevSpring.Aula05.controller;

import com.example.DevSpring.Aula05.model.Produto05;
import com.example.DevSpring.Aula05.service.ProdutoService05;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula05-produto")
public class ProdutoController05 {

    private final ProdutoService05 produtoService05;

    public ProdutoController05(ProdutoService05 produtoService05) {
        this.produtoService05 = produtoService05;
    }

    @PostMapping
    public ResponseEntity<Produto05> save(@RequestBody Produto05 produto){
        Produto05 produtoSalvo = produtoService05.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
