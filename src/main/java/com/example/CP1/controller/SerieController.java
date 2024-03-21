package com.example.CP1.controller;

import com.example.CP1.controller.dto.SerieDTO;
import com.example.CP1.model.Filme;
import com.example.CP1.model.Serie;
import com.example.CP1.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serie")
public class SerieController {
    @Autowired
    private SerieService serieService;


    // Adiciona um novo item ao estoque
    @PostMapping
    public ResponseEntity<Serie> adicionarSerie(@RequestBody SerieDTO serie) {
        Serie novoSerie = serieService.adicionarSerie(serie);
        return ResponseEntity.ok(novoSerie);
    }

    // Atualiza a quantidade de um item específico
    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizarSerie(@PathVariable Long id, @RequestBody SerieDTO serieDTO) {
        Serie serieAtualizado = serieService.atualizarSerie(id, serieDTO);
        return ResponseEntity.ok(serieAtualizado);
    }

    // Lista a serie pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Serie> encontrarSerieId(@PathVariable Long id) {
        Serie serie = serieService.encontrarSerieId(id);
        if (serie != null) {
            return ResponseEntity.ok(serie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lista todos os series
    @GetMapping
    public ResponseEntity<List<Serie>> listarSeries() {
        List<Serie> series = serieService.listarSeries();
        if (!series.isEmpty()) {
            return ResponseEntity.ok(series);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Lista filmes pelo Genero
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Serie>> listarSerieGenero(@PathVariable String genero) {
        List<Serie> series = serieService.listarSeriesPorGenero(genero);
        if (!series.isEmpty()) {
            return ResponseEntity.ok(series);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Lista Series pelo Ano de Lancamento
    @GetMapping("/ano/{anoLancamento}")
    public ResponseEntity<List<Serie>> listarFilmesAnoLancamento(@PathVariable Integer anoLancamento) {
        List<Serie> series = serieService.listarSeriesAnoLancamento(anoLancamento);
        if (!series.isEmpty()) {
            return ResponseEntity.ok(series);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Lista filmes pelo titulo
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Serie> encontrarSerieTitulo(@PathVariable String titulo) {
        Serie serie = serieService.encontrarSerieTitulo(titulo);
        if (serie != null) {
            return ResponseEntity.ok(serie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove uma serie pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerSerie(@PathVariable Long id) {
        serieService.removerSerie(id);
        return ResponseEntity.ok().build();
    }


}

