import java.util.Scanner;

public class Lectura {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Escribe el nombre de tu pelicula favorita: ");

    String pelicula = teclado.nextLine();

    System.out.println("Ahora escribe la fecha de lanzamiento");
    int fechaLanzamiento = teclado.nextInt();

    System.out.println("Que nota le das a esta pelicula?");
    double nota = teclado.nextDouble();

    System.out.printf("""
      Tu pelicula favorita es: %s
      La fecha en la que fue lanzada es: %d
      La nota que le diste es de: %.1f
      %n""", pelicula, fechaLanzamiento, nota);


  }
}
