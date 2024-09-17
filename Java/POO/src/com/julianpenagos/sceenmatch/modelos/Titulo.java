package com.julianpenagos.sceenmatch.modelos;

public class Titulo {

  private String nombre;
  private int fechaDeLanzamiento;
  private int DuracionEnMinutos;
  private boolean incluidoEnElPlan;
  private double sumaEvaluaciones;
  private int totalEvaluaciones;

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
        """, this.nombre, this.fechaDeLanzamiento, this.DuracionEnMinutos);

  }

  public void evalua(double nota) {
    this.sumaEvaluaciones += nota;
    this.totalEvaluaciones++;
  }

  public double calculaMedia() {
    return this.sumaEvaluaciones / totalEvaluaciones;
  }

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
    return DuracionEnMinutos;
  }

  public void setDuracionEnMinutos(int duracionEnMinutos) {
    DuracionEnMinutos = duracionEnMinutos;
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

}
