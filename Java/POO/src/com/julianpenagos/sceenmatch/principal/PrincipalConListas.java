package com.julianpenagos.sceenmatch.principal;

import com.julianpenagos.sceenmatch.modelos.Pelicula;
import com.julianpenagos.sceenmatch.modelos.Serie;
import com.julianpenagos.sceenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalConListas {
  public static void main(String[] args) {

    Pelicula miPelicula = new Pelicula("Encanto", 2021);
    miPelicula.evalua(9);
    Pelicula peliculaBruno = new Pelicula("El señor de los anillos", 2001);
    peliculaBruno.evalua(6);
    Serie casaDragon = new Serie("La casa del dragon", 2022);

    ArrayList<Titulo> lista = new ArrayList<>();
    lista.add(miPelicula);
    lista.add(peliculaBruno);
    lista.add(casaDragon);

    for (Titulo item : lista) {
      System.out.println(item.getNombre());

      if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
        System.out.println(pelicula.getClasificacion());
      }

    }

    List<String> listaArtistas = new ArrayList<>();
    listaArtistas.add("Penélope Cruz");
    listaArtistas.add("Antonio Banderas");
    listaArtistas.add("Ricardo Darín");

    Collections.sort(listaArtistas);

    System.out.println("Lista de artistas Ordenada: " + listaArtistas);

    Collections.sort(lista);
    System.out.println("Lista de titulos ordenados: " + lista);

    lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
    System.out.println("Lista ordenada por fecha: " + lista);
  }
}
