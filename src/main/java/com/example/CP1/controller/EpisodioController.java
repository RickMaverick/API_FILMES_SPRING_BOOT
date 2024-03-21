package com.example.CP1.controller;

import com.example.CP1.controller.dto.EpisodioDTO;
import com.example.CP1.model.Episodio;
import com.example.CP1.service.EpisodioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodio")
public class EpisodioController {
    @Autowired
    private EpisodioService episodioService;


    // Adiciona um novo item ao estoque
    @PostMapping
    public ResponseEntity<Episodio> adicionarEpisodio(@RequestBody EpisodioDTO episodio) {
        Episodio novoEpisodio = episodioService.adicionarEpisodio(episodio);
        return ResponseEntity.ok(novoEpisodio);
    }

    // Atualiza a quantidade de um item específico
    @PutMapping("/{id}")
    public ResponseEntity<Episodio> atualizarEpisodio(@PathVariable Long id, @RequestBody EpisodioDTO episodioDTO) {
        Episodio episodioAtualizado = episodioService.atualizarEpisodio(id, episodioDTO);
        return ResponseEntity.ok(episodioAtualizado);
    }

    // Lista o episodio pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Episodio> encontrarEpisodioId(@PathVariable Long id) {
        Episodio episodio = episodioService.encontrarEpisodioId(id);
        if (episodio != null) {
            return ResponseEntity.ok(episodio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lista todos os episodios
    @GetMapping
    public ResponseEntity<List<Episodio>> listarEpisodios() {
        List<Episodio> episodios = episodioService.listarEpisodios();
        if (!episodios.isEmpty()) {
            return ResponseEntity.ok(episodios);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Remove um item do estoque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEpisodio(@PathVariable Long id) {
        episodioService.removerEpisodio(id);
        return ResponseEntity.ok().build();
    }

}

