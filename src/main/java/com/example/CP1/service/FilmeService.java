package com.example.CP1.service;

import com.example.CP1.Repository.FilmeRepository;
import com.example.CP1.controller.dto.FilmeDTO;
import com.example.CP1.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    //Criar filme na lista
    public Filme adicionarFilme(FilmeDTO novo) {
        Filme filme = new Filme();
        filme.setTitulo(novo.getTitulo());
        filme.setDescricao(novo.getDescricao());
        filme.setAnoLancamento(novo.getAnoLancamento());
        filme.setDiretor(novo.getDiretor());
        filme.setGenero(novo.getGenero());
        return filmeRepository.save(filme);
    }

    // Atualiza a lista de filmes
    public Filme atualizarFilme(Long id, FilmeDTO filmeDTO) {
        Optional<Filme> filmeExistente = filmeRepository.findById(id);

        if(filmeExistente.isPresent()) {
            Filme filmeAtualizado = filmeExistente.get();
            filmeAtualizado.setTitulo(filmeDTO.getTitulo());
            filmeAtualizado.setDescricao(filmeDTO.getDescricao());
            filmeAtualizado.setAnoLancamento(filmeDTO.getAnoLancamento());
            filmeAtualizado.setDiretor(filmeDTO.getDiretor());
            filmeAtualizado.setGenero(filmeDTO.getGenero());
            return filmeRepository.save(filmeAtualizado);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

    // Lista todos filmes
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    //Listar filme específico
    public Filme encontrarFilmeId(Long id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        return filmeOptional.orElse(null);
    }

    //Listar filme pelo titulo
    public Filme encontrarFilmeTitulo(String titulo) {
        Optional<Filme> filmeOptional = filmeRepository.findByTitulo(titulo);
        return filmeOptional.orElse(null);
    }

    //Listar filmes pelo Genero
    public List<Filme> listarFilmesPorGenero(String genero) {
        return filmeRepository.findByGeneroContaining(genero);
    }

    //Listar filmes pelo Ano de Publicacao
    public List<Filme> listarFilmesAnoLancamento(Integer anoLancamento) {
        return filmeRepository.findByAnoLancamento(anoLancamento);
    }

    // Deletar filme da lista
    public void removerFilme(Long id) {
        if(filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

}
