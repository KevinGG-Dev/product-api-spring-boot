package com.github.apiprodutosspring.service;

import com.github.apiprodutosspring.model.Produto;
import com.github.apiprodutosspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvarProduto(Produto produto){
       try {
           String id = UUID.randomUUID().toString();
           produto.setId(id);
           produtoRepository.save(produto);
       } catch (Exception ex) {
       System.out.println("Erro: " + ex.getMessage() + " ao tentar salvar o produto.");
       }
    }
}
