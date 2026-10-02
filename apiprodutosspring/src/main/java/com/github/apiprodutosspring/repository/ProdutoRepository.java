package com.github.apiprodutosspring.repository;

import com.github.apiprodutosspring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,String> {
}
