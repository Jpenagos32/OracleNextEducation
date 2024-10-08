package com.julianpenagos.sceenmatch.modelos;

public class Serie extends Titulo {
  private int temporadas;
  private int episodiosPorTemporada;
  private int minutosPorEpisodio;

  public Serie(String nombre, int fechaDeLanzamiento) {
    super(nombre, fechaDeLanzamiento);
  }

  @Override
  public String toString(){
    return "Serie: " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";
  }

  @Override // indica que este metodo es una sobre escritura
  public int getDuracionEnMinutos() {
    return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
  }

  //  GETTERS Y SETTERS
  public int getTemporadas() {
    return temporadas;
  }

  public void setTemporadas(int temporadas) {
    this.temporadas = temporadas;
  }

  public int getEpisodiosPorTemporada() {
    return episodiosPorTemporada;
  }

  public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
    this.episodiosPorTemporada = episodiosPorTemporada;
  }

  public int getMinutosPorEpisodio() {
    return minutosPorEpisodio;
  }

  public void setMinutosPorEpisodio(int minutosPorEpisodio) {
    this.minutosPorEpisodio = minutosPorEpisodio;
  }

}
