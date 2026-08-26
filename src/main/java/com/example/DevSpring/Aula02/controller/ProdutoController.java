package com.example.DevSpring.Aula02.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula02-produto")
public class ProdutoController {

    @PutMapping("/{id}")    
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody String produtoAtualizado)  {
        return ResponseEntity.ok("Atualizando produto ID " + id + " para: " + produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        return ResponseEntity.ok("Produto deletado");
    }
}