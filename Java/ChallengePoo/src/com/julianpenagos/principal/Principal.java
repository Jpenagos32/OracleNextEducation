package com.julianpenagos.principal;

import com.julianpenagos.tipos.Cancion;
import com.julianpenagos.tipos.MisFavoritos;
import com.julianpenagos.tipos.Podcast;

public class Principal {
  public static void main(String[] args) {
    Cancion miCancion = new Cancion();
    miCancion.setTitulo("Forever");
    miCancion.setArtista("Kiss");

    Podcast miPodcast = new Podcast();
    miPodcast.setPresentador("Gabriela");
    miPodcast.setTitulo("Café.Tech");

    // Cancion
    for (int i = 0; i < 100; i++) {
      miCancion.meGusta();
    }

    for (int i = 0; i < 200; i++) {
      miCancion.reproduce();
    }

    // podcast
    for (int i = 0; i < 100; i++) {
      miPodcast.meGusta();
    }

    for (int i = 0; i < 8000; i++) {
      miPodcast.reproduce();
    }

    System.out.println("Total de reproducciones: " +miCancion.getTotalDeReproducciones());
    System.out.println("Total de me gusta: " + miCancion.getTotalDeMeGusta());

    MisFavoritos favoritos = new MisFavoritos();
    favoritos.adicione(miPodcast);
    favoritos.adicione(miCancion);
  }
}
