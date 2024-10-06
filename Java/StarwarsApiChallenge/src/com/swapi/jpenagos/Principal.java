package com.swapi.jpenagos;


import java.io.IOException;
import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    ConsultaPelicula consulta = new ConsultaPelicula();
    System.out.println("Escriba el número de la pelicula que desea buscar: ");

    try {
      var numeroPelicula = Integer.parseInt(scan.nextLine());
      Pelicula pelicula = consulta.buscaPelicula(numeroPelicula);

      GeneradorArchivo generador = new GeneradorArchivo();
      generador.guardarJson(pelicula);

    } catch (NumberFormatException e) {
      System.out.println("número no encontrado " + e.getMessage());
    } catch (RuntimeException | IOException e) {
      System.out.println(e.getMessage());
      System.out.println("Finalizando la aplicación");
    }

  }
}
