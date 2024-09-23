package com.julianpenagos.sceenmatch.modelos;

import com.julianpenagos.sceenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion{
  private String director;

  
  @Override
  public int getClasificacion() {
    return (int) (calculaMedia() / 2);
  }

  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }

}
