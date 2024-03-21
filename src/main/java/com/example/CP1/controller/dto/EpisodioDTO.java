package com.example.CP1.controller.dto;

import com.example.CP1.model.Serie;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EpisodioDTO {
    private Long id;

    private String titulo;

    private Integer numero;

    private Integer temporada;

    @ManyToOne
    private Serie serie;
}