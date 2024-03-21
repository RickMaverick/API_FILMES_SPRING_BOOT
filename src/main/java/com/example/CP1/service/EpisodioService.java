package com.example.CP1.service;

import com.example.CP1.Repository.EpisodioRepository;
import com.example.CP1.controller.dto.EpisodioDTO;
import com.example.CP1.model.Episodio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EpisodioService {

    @Autowired
    private EpisodioRepository episodioRepository;

    //Criar episodio na lista
    public Episodio adicionarEpisodio(EpisodioDTO novo) {
        Episodio episodio = new Episodio();
        episodio.setTitulo(novo.getTitulo());
        episodio.setNumero(novo.getNumero());
        episodio.setTemporada(novo.getTemporada());
        return episodioRepository.save(episodio);
    }

    // Atualiza a lista de episodios
    public Episodio atualizarEpisodio(Long id, EpisodioDTO episodioDTO) {
        Optional<Episodio> episodioExistente = episodioRepository.findById(id);

        if(episodioExistente.isPresent()) {
            Episodio episodioAtualizado = episodioExistente.get();
            episodioAtualizado.setTitulo(episodioDTO.getTitulo());
            episodioAtualizado.setNumero(episodioDTO.getNumero());
            episodioAtualizado.setTemporada(episodioDTO.getTemporada());

            return episodioRepository.save(episodioAtualizado);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

    // Lista todos episodios
    public List<Episodio> listarEpisodios() {
        return episodioRepository.findAll();
    }

    //Listar episodio específico
    public Episodio encontrarEpisodioId(Long id) {
        Optional<Episodio> episodioOptional = episodioRepository.findById(id);
        return episodioOptional.orElse(null);
    }


    // Deletar episodio da lista
    public void removerEpisodio(Long id) {
        if(episodioRepository.existsById(id)) {
            episodioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item não encontrado com o ID: " + id);
        }
    }

}

