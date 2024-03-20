package com.example.CP1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Filme {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Integer anoLancamento;

    @Column
    private String diretor;

    @Column
    private String genero;

}

