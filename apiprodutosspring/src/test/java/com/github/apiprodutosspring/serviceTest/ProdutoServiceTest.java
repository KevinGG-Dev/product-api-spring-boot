package com.github.apiprodutosspring.serviceTest;

import com.github.apiprodutosspring.model.Produto;
import com.github.apiprodutosspring.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
public class ProdutoServiceTest {

    @Autowired
    ProdutoService produtoService;

    @Test
    public void salvarProdutoTest (){
            Produto produto = new Produto();
            produto.setNome("Mouse");
            produto.setDescricao("Mouse LogiTech");
            produto.setPreco(BigDecimal.valueOf(300));
            String id = UUID.randomUUID().toString();
            produto.setId(id);

            produtoService.salvarProduto(produto);

            System.out.println("Produto: " + produto.toString() + " salvo com sucesso");
    }
}
