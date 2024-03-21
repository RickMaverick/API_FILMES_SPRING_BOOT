package com.example.CP1.Repository;

import com.example.CP1.controller.dto.EpisodioDTO;
import com.example.CP1.model.Filme;
import com.example.CP1.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    // DIFERENTAO
    @Query("SELECT DISTINCT s FROM Serie s JOIN s.episodios e WHERE s.titulo = :titulo OR s.genero = :genero OR s.anoLancamento = :anoLancamento OR e.temporada = :temporada")
    List<Serie> findByTemporada(@Param("temporada") Integer temporada);

    List<Serie> findByAnoLancamento(Integer anoLancamento);

    List<Serie> findByGeneroContaining(String genero);

    Optional<Serie> findByTitulo(String titulo);
}
