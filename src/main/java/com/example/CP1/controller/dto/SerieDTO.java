package com.example.CP1.controller.dto;

import com.example.CP1.model.Episodio;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class SerieDTO {
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
    private String genero;

    @OneToMany
    private List<Episodio> episodios;
}
