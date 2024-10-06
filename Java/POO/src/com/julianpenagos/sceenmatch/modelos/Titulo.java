package com.julianpenagos.sceenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import com.julianpenagos.sceenmatch.excepcion.ErrorEnConversionDeDuracionException;

public class Titulo implements Comparable<Titulo> {
  @SerializedName("Title")
  private String nombre;
  @SerializedName("Year")
  private int fechaDeLanzamiento;
  private int duracionEnMinutos;
  private boolean incluidoEnElPlan;
  private double sumaEvaluaciones;
  private int totalEvaluaciones;

  public Titulo(String nombre, int fechaDeLanzamiento) {
    this.nombre = nombre;
    this.fechaDeLanzamiento = fechaDeLanzamiento;
  }

  public Titulo(TituloOMDB miTituloOMDB) {
    this.nombre = miTituloOMDB.title();
    this.fechaDeLanzamiento = Integer.valueOf(miTituloOMDB.year());

    if(miTituloOMDB.runtime().contains("N/A")){
      throw new ErrorEnConversionDeDuracionException("No pude convertir la duración porque tiene un N/A");
    }
    this.duracionEnMinutos = Integer.valueOf(miTituloOMDB.runtime().substring(0,2));

  }

  public void muestraFichaTecnica() {
    System.out.println("El nombre de la pelicula es: " + this.nombre);
    System.out.println("Su fecha de lanzamiento es: " + this.fechaDeLanzamiento);
    System.out.println("Duración en minutos: " + getDuracionEnMinutos());
  }

  public void mostrarPelicula() {

    System.out.printf("""
      +---------------------------------------+
                       Pelicula
      +---------------------------------------+
       Nombre               |%s
      +---------------------+-----------------+
       Fecha de lanzamiento |%d
      +---------------------+-----------------+
       Duración             |%d
      +---------------------+-----------------+
      """, this.nombre, this.fechaDeLanzamiento, this.duracionEnMinutos);

  }

  public void evalua(double nota) {
    this.sumaEvaluaciones += nota;
    this.totalEvaluaciones++;
  }

  public double calculaMedia() {
    return this.sumaEvaluaciones / totalEvaluaciones;
  }

  @Override
  public int compareTo(Titulo otroTitulo) {
    return this.getNombre().compareTo(otroTitulo.getNombre());
  }

  /* GETTERS AND SETTERS */
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getFechaDeLanzamiento() {
    return fechaDeLanzamiento;
  }

  public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
    this.fechaDeLanzamiento = fechaDeLanzamiento;
  }

  public int getDuracionEnMinutos() {
    return duracionEnMinutos;
  }

  public void setDuracionEnMinutos(int duracionEnMinutos) {
    this.duracionEnMinutos = duracionEnMinutos;
  }

  public boolean isIncluidoEnElPlan() {
    return incluidoEnElPlan;
  }

  public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
    this.incluidoEnElPlan = incluidoEnElPlan;
  }

  public double getSumaEvaluaciones() {
    return sumaEvaluaciones;
  }

  public void setSumaEvaluaciones(double sumaEvaluaciones) {
    this.sumaEvaluaciones = sumaEvaluaciones;
  }

  public int getTotalEvaluaciones() {
    return totalEvaluaciones;
  }

  public void setTotalEvaluaciones(int totalEvaluaciones) {
    this.totalEvaluaciones = totalEvaluaciones;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Titulo{");
    sb.append("nombre='").append(nombre).append('\'');
    sb.append(", fechaDeLanzamiento=").append(fechaDeLanzamiento);
    sb.append(", duracion=").append(duracionEnMinutos);
    sb.append('}');
    return sb.toString();
  }
}
