package com.example.CP1.Repository;

import com.example.CP1.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByAnoLancamento(Integer anoLancamento);

    List<Serie> findByGeneroContaining(String genero);

    Optional<Serie> findByTitulo(String titulo);

    @Query("SELECT s FROM Serie s JOIN s.episodios e GROUP BY s HAVING COUNT(DISTINCT e.temporada) = :temporada")
    List<Serie> findByTemporada(@Param("temporada") Integer temporada);
}