package com.example.CP1.Repository;

import com.example.CP1.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByAnoLancamento(Integer anoLancamento);

    List<Serie> findByGeneroContaining(String genero);

    Optional<Serie> findByTitulo(String titulo);

    List<Serie> findbyEpisodios_Temporada(Integer temporada);
}
