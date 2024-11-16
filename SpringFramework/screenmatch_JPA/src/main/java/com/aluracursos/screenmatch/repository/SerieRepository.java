package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aluracursos.screenmatch.model.Serie;

import java.util.List;
import java.util.Optional;

// <Serie, Long> hacen referencia al tipo de objeto y al tipo de dato del ID dentro de dicho objeto
public interface SerieRepository extends JpaRepository<Serie, Long> {
  Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

  List<Serie> findTop5ByOrderByEvaluacionDesc();
  List<Serie> findByGenero (Categoria categoria);
  List<Serie> findByTotalTemporadasLessThanEqual(int cantidad);
  List<Serie> findByTotalTemporadas(int cantidad);
}
