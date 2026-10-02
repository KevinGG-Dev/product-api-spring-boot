package com.github.apiprodutosspring.controller;

import com.github.apiprodutosspring.model.Produto;
import com.github.apiprodutosspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoController() {
    }

    @PostMapping
    public void salvarProduto(@RequestBody Produto produto){
        try {
            String id = UUID.randomUUID().toString();
            produto.setId(id);
            produtoRepository.save(produto);
            System.out.println("Produto: " + produto.toString() + " salvo com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao salvar produto: " + ex.getMessage());
        }
    }
}
