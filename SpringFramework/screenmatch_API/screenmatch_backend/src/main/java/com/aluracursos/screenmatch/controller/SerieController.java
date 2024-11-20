package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// esta anotacion es necesario para poder crear una API
@RestController
public class SerieController {

  //Traemos la dependencia de SerieService
  @Autowired
  private SerieService servicio;

  // Con esta anotacion estamos diciendo que el metodo lo mapeamos a la ruta /series y que es el método GET
  @GetMapping("/series")
  public List<SerieDTO> mostrarMensaje() {
    return servicio.obtenerTodasLasSeries();
  }

  @GetMapping("/series/top5")
  public List<SerieDTO> obtenerTop5 (){
    return servicio.obtenerTop5();
  }

}
