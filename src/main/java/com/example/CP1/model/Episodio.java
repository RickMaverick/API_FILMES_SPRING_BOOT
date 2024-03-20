package com.example.CP1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Episodio {
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
