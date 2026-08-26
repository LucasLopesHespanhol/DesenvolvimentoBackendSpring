package com.example.DevSpring.Aula01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula01-produto")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<String> listarProdutos() {
        return ResponseEntity.ok("Listagem de Produtos");
    }

    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody String produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Criado com Sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody String produtoAtualizdo) {
        return ResponseEntity.ok("Produto Atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        return ResponseEntity.ok("Produto deletado");
    }

}
