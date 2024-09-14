package screenmatch;

public class Principal {
  public static void main(String[] args) {
    Pelicula miPelicula = new Pelicula();
    miPelicula.nombre = "Encanto";
    miPelicula.fechaDeLanzamiento = 2021;
    miPelicula.DuracionEnMinutos = 120;
    miPelicula.mostrarPelicula();
    miPelicula.evalua(10);
    miPelicula.evalua(10);

    System.out.println(miPelicula.sumaEvaluaciones);
    System.out.println(miPelicula.totalEvaluaciones);
    System.out.println(miPelicula.calculaMedia());


  }
}
