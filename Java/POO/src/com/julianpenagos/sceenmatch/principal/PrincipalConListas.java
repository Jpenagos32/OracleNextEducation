package com.julianpenagos.sceenmatch.principal;

import com.julianpenagos.sceenmatch.modelos.Pelicula;
import com.julianpenagos.sceenmatch.modelos.Serie;
import com.julianpenagos.sceenmatch.modelos.Titulo;

import java.util.ArrayList;

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

  }
}
