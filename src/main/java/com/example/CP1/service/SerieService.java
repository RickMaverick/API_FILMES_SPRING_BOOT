package com.example.CP1.service;

import com.example.CP1.Repository.SerieRepository;
import com.example.CP1.controller.dto.SerieDTO;
import com.example.CP1.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    //Criar serie na lista
    public Serie adicionarSerie(SerieDTO novo) {
        Serie serie = new Serie();
        serie.setTitulo(novo.getTitulo());
        serie.setDescricao(novo.getDescricao());
        serie.setAnoLancamento(novo.getAnoLancamento());
        serie.setGenero(novo.getGenero());
        serie.setEpisodios(novo.getEpisodios());
        return serieRepository.save(serie);
    }

    // Atualiza a lista de series
    public Serie atualizarSerie(Long id, SerieDTO serieDTO) {
        Optional<Serie> serieExistente = serieRepository.findById(id);

        if(serieExistente.isPresent()) {
            Serie serieAtualizado = serieExistente.get();
            serieAtualizado.setTitulo(serieDTO.getTitulo());
            serieAtualizado.setDescricao(serieDTO.getDescricao());
            serieAtualizado.setAnoLancamento(serieDTO.getAnoLancamento());
            serieAtualizado.setGenero(serieDTO.getGenero());
            serieAtualizado.setEpisodios(serieDTO.getEpisodios());
            return serieRepository.save(serieAtualizado);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

    // Lista todos series
    public List<Serie> listarSeries() {
        return serieRepository.findAll();
    }

    //Listar serie específico
    public Serie encontrarSerieId(Long id) {
        Optional<Serie> serieOptional = serieRepository.findById(id);
        return serieOptional.orElse(null);
    }

    // Deletar serie da lista
    public void removerSerie(Long id) {
        if(serieRepository.existsById(id)) {
            serieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

    //Listar series pelo Ano de Publicacao
    public List<Serie> listarSeriesAnoLancamento(Integer anoLancamento) {
        return serieRepository.findByAnoLancamento(anoLancamento);
    }

    //Listar Series pelo Genero
    public List<Serie> listarSeriesPorGenero(String genero) {
        return serieRepository.findByGeneroContaining(genero);
    }

    //Listar Series pelo Titulo
    public Serie encontrarSerieTitulo(String titulo) {
        Optional<Serie> filmeOptional = serieRepository.findByTitulo(titulo);
        return filmeOptional.orElse(null);
    }

    public List<Serie> buscarSeriesPorTemporada(Integer temporada) {
        return serieRepository.findbyEpisodios_Temporada(temporada);
    }
}
