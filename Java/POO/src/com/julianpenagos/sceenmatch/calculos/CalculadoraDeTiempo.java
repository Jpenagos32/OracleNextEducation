package com.julianpenagos.sceenmatch.calculos;

import com.julianpenagos.sceenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
  private int tiempoTotal;

  public void incluye(Titulo titulo){
    this.tiempoTotal += titulo.getDuracionEnMinutos();
  }

  public int getTiempoTotal() {
    return tiempoTotal;
  }

}
