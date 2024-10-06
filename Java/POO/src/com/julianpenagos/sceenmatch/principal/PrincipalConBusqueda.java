package com.julianpenagos.sceenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julianpenagos.sceenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.julianpenagos.sceenmatch.modelos.Titulo;
import com.julianpenagos.sceenmatch.modelos.TituloOMDB;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalConBusqueda {
  public static void main(String[] args) throws IOException, InterruptedException {

    Scanner scan = new Scanner(System.in);

    System.out.println("Escriba el nombre de una pelicula: ");
    var busqueda = scan.nextLine();

    String direccion = "https://www.omdbapi.com/?t=" + encodeUrl(busqueda) + "&apikey=1e57290d";


    try {

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(direccion))
        .build();

      HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();
      System.out.println(json);

      Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();

      TituloOMDB miTituloOMDB = gson.fromJson(json, TituloOMDB.class);
      System.out.println(miTituloOMDB);

      Titulo miTitulo = new Titulo(miTituloOMDB);
      System.out.println("Titulo ya convertido: " + miTitulo);
    } catch (NumberFormatException e) {
      System.out.println("Ocurrio un error");
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e){
      System.out.println("Error en la URI, verifique la dirección");
    } catch (ErrorEnConversionDeDuracionException e){
      System.out.println(e.getMessage());
    }

    System.out.println("Finalizó la ejecución del programa");

  }

  private static String encodeUrl(String url) {
    try {
      return URLEncoder.encode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }

  }
}
