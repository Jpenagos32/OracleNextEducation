package com.swapi.jpenagos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

  public Pelicula buscaPelicula(int numeroPelicula) {
    URI url = URI.create("https://swapi.dev/api/films/" + numeroPelicula);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(url)
      .build();

    try {
      HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());
      return new Gson().fromJson(response.body(), Pelicula.class);
    } catch (Exception e) {
      throw new RuntimeException("No encontré esta pelicula");
    }
  }
}
