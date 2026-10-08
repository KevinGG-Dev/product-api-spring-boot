package com.github.apiprodutosspring.service;

import com.github.apiprodutosspring.model.Produto;
import com.github.apiprodutosspring.repository.ProdutoRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvarProduto(@NonNull Produto produto){

           String id = UUID.randomUUID().toString();
           produto.setId(id);
           produtoRepository.save(produto);

    }

    public List<Produto> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        System.out.println(produtos.toString());
        return produtos;
    }

    public Produto getProdutoPorId(String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }
}
