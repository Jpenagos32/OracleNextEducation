package com.julianpenagos.sceenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julianpenagos.sceenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.julianpenagos.sceenmatch.modelos.Titulo;
import com.julianpenagos.sceenmatch.modelos.TituloOMDB;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
  public static void main(String[] args) throws IOException, InterruptedException {

    Scanner scan = new Scanner(System.in);
    List<Titulo> titulos = new ArrayList<>();

    Gson gson = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
      .setPrettyPrinting()
      .create();

    while (true) {

      System.out.println("Escriba el nombre de una pelicula: ");
      var busqueda = scan.nextLine();

      if (busqueda.equalsIgnoreCase("salir")) {
        break;
      }

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

        TituloOMDB miTituloOMDB = gson.fromJson(json, TituloOMDB.class);
        System.out.println(miTituloOMDB);

        Titulo miTitulo = new Titulo(miTituloOMDB);
        System.out.println("Titulo ya convertido: " + miTitulo);

        titulos.add(miTitulo);

      } catch (NumberFormatException e) {
        System.out.println("Ocurrio un error");
        System.out.println(e.getMessage());
      } catch (IllegalArgumentException e) {
        System.out.println("Error en la URI, verifique la dirección");
      } catch (ErrorEnConversionDeDuracionException e) {
        System.out.println(e.getMessage());
      }


    }

    FileWriter escritura = new FileWriter("titulos.json");
    escritura.write(gson.toJson(titulos));
    escritura.close();

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
