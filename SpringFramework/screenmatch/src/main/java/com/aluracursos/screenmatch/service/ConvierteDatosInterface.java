package com.aluracursos.screenmatch.service;

public interface ConvierteDatosInterface {
  <T> T obtenerDatos(String json, Class<T> clase);
}
