package com.github.apiprodutosspring.model;

import lombok.Data;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@EntityScan
@Data
public class Produto {

    @Id
    @Column
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal preco;

}
