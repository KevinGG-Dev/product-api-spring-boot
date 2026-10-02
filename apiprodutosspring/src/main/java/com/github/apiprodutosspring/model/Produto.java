package com.github.apiprodutosspring.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Entity
@Data
@ToString
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
