package com.example.CP1.controller.dto;

import com.example.CP1.model.Serie;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class EpisodioDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titulo;

    @Column
    private Integer numero;

    @Column
    private Integer temporada;

    @ManyToOne
    private Serie serie;
}