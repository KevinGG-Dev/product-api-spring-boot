package com.github.apiprodutosspring.controller;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity salvarProduto(@RequestBody Produto produto){
            produtoService.salvarProduto(produto);
            System.out.println("Produto: " + produto.toString() + " salvo com sucesso");
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        ResponseEntity.status(HttpStatus.OK).build();
        return produtoService.listarProdutos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity infoProdutoPorId(@PathVariable String id){
        Optional<Produto> produto = Optional.ofNullable(produtoService.getProdutoPorId(id));
        return produto.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutoPorId(id)) : null;
    }

    @DeleteMapping
    public ResponseEntity deletarProdutoPorId(@RequestParam ("id") String id){
        String produtoParaDeletar = produtoService.excluirProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping ("/{id}")
    public void atualizarProduto(@PathVariable String id, @RequestBody @NonNull Produto produto){
        if (id.equals(produto.getId())){
            produtoService.atualizarProduto(produto);
            ResponseEntity.status(HttpStatus.OK).body(produto.toString());
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
