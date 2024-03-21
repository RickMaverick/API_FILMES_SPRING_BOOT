package com.example.CP1.Repository;
import com.example.CP1.model.Episodio;
import com.example.CP1.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    List<Episodio> findByTemporada(Integer temporada);

}



