package com.github.apiprodutosspring.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Entity
@Data
@ToString
public class Produto {


    @Column
    @Id
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal preco;

}
