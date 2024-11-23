package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// esta anotacion es necesario para poder crear una API
@RestController
@RequestMapping("/series") // Esta anotacion indica que todo lo de este controlador irá a /series como URL base
public class SerieController {

  //Traemos la dependencia de SerieService
  @Autowired
  private SerieService servicio;

  // Con esta anotacion estamos diciendo que el metodo lo mapeamos a la ruta /series y que es el método GET
  @GetMapping()
  public List<SerieDTO> mostrarMensaje() {
    return servicio.obtenerTodasLasSeries();
  }

  @GetMapping("/top5")
  public List<SerieDTO> obtenerTop5 (){
    return servicio.obtenerTop5();
  }

  @GetMapping("lanzamientos")
  public List<SerieDTO> obtenerLanzamientosMasRecientes () {
    return servicio.obtenerLanzamientosMasRecientes();
  }

  @GetMapping("/{id}") // De esta forma indicamos que id es un parametro dinámico
  public SerieDTO obtenerPorId(@PathVariable Long id) { // la anotacion @PathVariable indica que ese id viene mediante la URL
    return servicio.obtenerPorId(id);
  }

  @GetMapping("/{id}/temporadas/todas")
  public List<EpisodioDTO> obtenerTodasLasTemporadas(@PathVariable Long id) {
    return servicio.obtenerTodasLasTemporadas(id);
  }

  @GetMapping("/{id}/temporadas/{numeroTemporada}")
  /*
  * Puedo tener tantas PathVariables como necesite, pero es importante que el parametro del método
  * tenga el mismo nombre que la PathVariable dentro del endpoint
  * */
  public List<EpisodioDTO> obtenerTemporadasPorNumero (@PathVariable Long id, @PathVariable Long numeroTemporada) {
    return servicio.obtenerTemporadasPorNumero(id, numeroTemporada);
  }

  @GetMapping("/categoria/{nombreGenero}")
  public List<SerieDTO> obtenerSeriesPorCategoria(@PathVariable String nombreGenero) {
    return servicio.obtenerSeriesPorCategoria(nombreGenero);
  }


}
