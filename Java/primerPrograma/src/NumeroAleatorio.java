import java.util.Random;
import java.util.Scanner;

public class NumeroAleatorio {
  public static void main(String[] args) {
    int aleatorio = 12;/* new Random().nextInt(100); */
    int intentos = 1;
    Scanner scanner = new Scanner(System.in);
    

    while (true) {
      System.out.printf("Intento número %d de 5\n", intentos);
      
      System.out.print("Ingrese un número: ");
      int numeroUsuario = scanner.nextInt();

      if (aleatorio == numeroUsuario){
        System.out.printf("Adivinó el número en %d intentos, felicidades", intentos);
        break;
      }

      if (intentos == 5){
        System.out.printf("El núero aleatorio era: %d, mejor suerte para la proxima", aleatorio);
        break;
      }

      if (numeroUsuario < aleatorio){
        System.out.println("El número secreto es mayor");
      }
      else if (numeroUsuario > aleatorio){
        System.out.println("El número secreto es menor");
      }

      intentos++;
    }

    scanner.close();

  }
}
