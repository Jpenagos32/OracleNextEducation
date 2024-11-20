package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Anotacion que se usa para identificar que esta parte es un servicio
@Service
public class SerieService {

  // Anotacion usada para inyectar la dependencia SerieRepository
  @Autowired
  private SerieRepository repository;

  public List<SerieDTO> obtenerTodasLasSeries() {
    return this.convierteDatos(repository.findAll());
  }

  public List<SerieDTO> obtenerTop5() {
    return this.convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());
  }

  public List<SerieDTO> convierteDatos(List<Serie> serie) {
    return serie.stream()
      .map(s -> new SerieDTO(
        s.getTitulo(),
        s.getTotalTemporadas(),
        s.getEvaluacion(),
        s.getPoster(),
        s.getGenero(),
        s.getActores(),
        s.getSinopsis()
      ))
      .collect(Collectors.toList());
  }
}
