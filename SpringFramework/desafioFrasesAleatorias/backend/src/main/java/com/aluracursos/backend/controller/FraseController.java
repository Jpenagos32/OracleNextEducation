package com.aluracursos.backend.controller;

import com.aluracursos.backend.dto.FraseDTO;
import com.aluracursos.backend.services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Esta anotacion es necesaria para indicar que este se trata de un controlador para una API rest
@RestController
public class FraseController {
  @Autowired
  private FraseService servicio;

  @GetMapping("/series/frases")
  public FraseDTO obtenerFraseAleatoria() {
    return servicio.obtenerFraseAleatoria();
  }
}
