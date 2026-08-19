package com.example.aula1.controller;

import com.example.aula1.model.Produto;
import com.example.aula1.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public ResponseEntity<String> listarProdutos() {
        return ResponseEntity.ok("Listagem de Produtos.");
    }

    @PostMapping
    public ResponseEntity<String> criarProdutos(@RequestBody String produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Criado com Sucesso");
    }

    @PutMapping("/{id}")    
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody String produtoAtualizado)  {
        return ResponseEntity.ok("Atualizando produto ID " + id + " para: " + produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        return ResponseEntity.ok("Produto deletado");
    }

    @GetMapping("/aula03")
    public ResponseEntity<List<Produto>> buscar(@RequestParam(required = false) String nome) {
        if (nome == null || nome.isBlank()) {
            return ResponseEntity.ok(produtoRepository.findAll());
        }

        return ResponseEntity.ok(produtoRepository.findByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("/aula03")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

}
