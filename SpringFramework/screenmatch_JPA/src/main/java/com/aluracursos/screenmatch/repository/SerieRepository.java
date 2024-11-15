package com.aluracursos.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aluracursos.screenmatch.model.Serie;

import java.util.Optional;

// <Serie, Long> hacen referencia al tipo de objeto y al tipo de dato del ID dentro de dicho objeto
public interface SerieRepository extends JpaRepository<Serie, Long> {
  Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);
}
