package com.example.CP1.Repository;

import com.example.CP1.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Optional<Filme> findByTitulo(String titulo);

    List<Filme> findByGeneroContaining(String genero);

    List<Filme> findByAnoLancamento(Integer anoLancamento);
}
