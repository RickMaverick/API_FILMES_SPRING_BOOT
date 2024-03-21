package com.example.CP1.controller.dto;

import com.example.CP1.model.Episodio;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
public class SerieDTO {
    private Long id;

    private String titulo;

    private String descricao;

    private Integer anoLancamento;

    private String genero;

    private List<Episodio> episodios;
}
