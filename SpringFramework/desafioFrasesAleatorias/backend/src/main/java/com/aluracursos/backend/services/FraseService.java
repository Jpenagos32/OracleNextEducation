package com.aluracursos.backend.services;

import com.aluracursos.backend.dto.FraseDTO;
import com.aluracursos.backend.model.Frase;
import com.aluracursos.backend.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
* El servicio se encarga de traer los datos de la base de datos
* 
* En esta clase se encuentran todos los querys que se ejecutan en la base de datos
*
*
* */

// Indicamos que esta clase es un servicio
@Service
public class FraseService {

  @Autowired
  private FraseRepository repository;

  public FraseDTO obtenerFraseAleatoria() {
    Frase frase = repository.obtenerFraseAleatoria();
    return new FraseDTO(
      frase.getTitulo(),
      frase.getFrase(),
      frase.getPersonaje(),
      frase.getPoster()
    );
  }
}
