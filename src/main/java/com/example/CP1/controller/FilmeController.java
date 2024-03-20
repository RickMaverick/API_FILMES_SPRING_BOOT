package com.example.CP1.controller;

import com.example.CP1.controller.dto.FilmeDTO;
import com.example.CP1.model.Filme;
import com.example.CP1.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    // Adiciona um novo item ao estoque
    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody FilmeDTO filme) {
        Filme novoFilme = filmeService.adicionarFilme(filme);
        return ResponseEntity.ok(novoFilme);
    }

    // Atualiza a filme pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        Filme filmeAtualizado = filmeService.atualizarFilme(id, filmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    // Lista filmes pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Filme> encontrarFilmeId(@PathVariable Long id) {
        Filme filme = filmeService.encontrarFilmeId(id);
        if (filme != null) {
            return ResponseEntity.ok(filme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lista todos os filmes
    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        if (!filmes.isEmpty()) {
            return ResponseEntity.ok(filmes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Lista filmes pelo titulo
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Filme> encontrarFilmeTitulo(@PathVariable String titulo) {
        Filme filme = filmeService.encontrarFilmeTitulo(titulo);
        if (filme != null) {
            return ResponseEntity.ok(filme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lista filmes pelo Genero
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Filme>> listarFilmesGenero(@PathVariable String genero) {
        List<Filme> filmes = filmeService.listarFilmesPorGenero(genero);
        if (!filmes.isEmpty()) {
            return ResponseEntity.ok(filmes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Lista filmes pelo Ano de Lancamento
    @GetMapping("/ano/{anoPublicacao}")
    public ResponseEntity<List<Filme>> listarFilmesAnoLancamento(@PathVariable Integer anoPublicacao) {
        List<Filme> filmes = filmeService.listarFilmesAnoLancamento(anoPublicacao);
        if (!filmes.isEmpty()) {
            return ResponseEntity.ok(filmes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Remove um item do estoque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFilme(@PathVariable Long id) {
        filmeService.removerFilme(id);
        return ResponseEntity.ok().build();
    }
}


