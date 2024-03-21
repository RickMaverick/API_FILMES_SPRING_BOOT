package com.example.CP1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Serie {
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serie_id")
    private List<Episodio> episodios;
}
