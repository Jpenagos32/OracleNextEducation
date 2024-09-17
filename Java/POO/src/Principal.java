

import com.julianpenagos.sceenmatch.modelos.Pelicula;

public class Principal {
  public static void main(String[] args) {
    Pelicula miPelicula = new Pelicula();
    miPelicula.setNombre("Encanto");
    miPelicula.setFechaDeLanzamiento(2021);
    miPelicula.setDuracionEnMinutos(120);
    miPelicula.setIncluidoEnElPlan(true);
    miPelicula.mostrarPelicula();
    miPelicula.evalua(10);
    miPelicula.evalua(10);

    System.out.println("Total de evaluaciones: " + miPelicula.getTotalEvaluaciones());
    System.out.println("Puntuación media de la pelicula: " + miPelicula.calculaMedia());

  }
}
