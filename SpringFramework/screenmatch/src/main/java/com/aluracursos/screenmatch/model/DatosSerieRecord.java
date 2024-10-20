package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerieRecord(
  @JsonAlias("Title") String titulo,
  @JsonAlias("totalSeasons") int totalDeTemporadas,
  @JsonAlias("imdbRating") String evaluacion
) {

}