package com.aluracursos.screenmatch.dto;

import com.aluracursos.screenmatch.model.Categoria;

// Esta clase es necesaria para que jackson databind convierta los objetos Java en JSON
public record SerieDTO(
  Long id,
  String titulo,
  Integer totalTemporadas,
  Double evaluacion,
  String poster,
  Categoria genero,
  String actores,
  String sinopsis
) {

}
