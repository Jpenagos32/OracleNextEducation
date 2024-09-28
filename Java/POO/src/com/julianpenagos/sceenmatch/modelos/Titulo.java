package com.julianpenagos.sceenmatch.modelos;

public class Titulo implements Comparable<Titulo> {

  private String nombre;
  private int fechaDeLanzamiento;
  private int duracionEnMinutos;
  private boolean incluidoEnElPlan;
  private double sumaEvaluaciones;
  private int totalEvaluaciones;

  public Titulo(String nombre, int fechaDeLanzamiento) {
    this.nombre = nombre;
    this.fechaDeLanzamiento = fechaDeLanzamiento;
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

}
