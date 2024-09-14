package screenmatch;

public class Pelicula {
  public String nombre;
  public int fechaDeLanzamiento;
  public int DuracionEnMinutos;
  public boolean incluidoEnElPlan;
  public double sumaEvaluaciones;
  public int totalEvaluaciones;

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
}
