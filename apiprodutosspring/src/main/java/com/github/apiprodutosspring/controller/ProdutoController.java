package com.github.apiprodutosspring.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.github.apiprodutosspring.model.Produto;
import com.github.apiprodutosspring.repository.ProdutoRepository;
import com.github.apiprodutosspring.service.ProdutoService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping (value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoController() {
    }

    @PostMapping
    public void salvarProduto(@RequestBody Produto produto){
        try {
            produtoService.salvarProduto(produto);
            System.out.println("Produto: " + produto.toString() + " salvo com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao salvar produto: " + ex.getMessage());
        }
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        List<Produto> produtosListados = produtoService.listarProdutos();
        return produtosListados;
    }

    @GetMapping ("/{id}")
    public Produto infoProdutoPorId(@PathVariable String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }

    @DeleteMapping
    public String deletarProdutoPorId(@RequestParam ("id") String id){
        Produto produtoParaDeletar = produtoRepository.findById(id).get();
        produtoRepository.delete(produtoParaDeletar);
        return "Produto: " + produtoParaDeletar.toString() + " deletado com sucesso";
    }

    @PutMapping
    public void atualizarProduto(@RequestParam String id, @RequestBody @NonNull Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

}
