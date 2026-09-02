package com.example.DevSpring.Aula05.service;

import com.example.DevSpring.Aula05.model.Produto05;
import com.example.DevSpring.Aula05.repository.ProdutoRepository05;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService05 {

    private final ProdutoRepository05 produtoRepository05;

    public ProdutoService05(ProdutoRepository05 produtoRepository05) {
        this.produtoRepository05 = produtoRepository05;
    }

    public Produto05 save(Produto05 produto05) {
        if (produto05.getNome().isBlank() || produto05.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome vazio ou inválido!");
        }
        if (produto05.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que 0!");
        }

        return produtoRepository05.save(produto05);
    }
}
