package com.example.CP1.controller.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class FilmeDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private Integer anoLancamento;

    private String diretor;

    private String genero;

}

