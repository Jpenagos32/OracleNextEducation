package com.aluracursos.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements ConvierteDatosInterface {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public <T> T obtenerDatos(String json, Class<T> clase) {
    try {
      return this.objectMapper.readValue(json, clase);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
