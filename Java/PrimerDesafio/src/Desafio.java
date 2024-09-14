import java.util.Scanner;

public class Desafio {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean salir = false;
    double saldo = 2000.00;
    String nombreCliente = "Julian Penagos";

    System.out.println("***Bienvenido " + nombreCliente + "***");

    while (!salir) {

      System.out.println("""
          **Seleccione la operación que desea realizar***
          1. Consultar Saldo
          2. Retirar
          3. Depositar
          9. Salir
          """);
      int opcion = scanner.nextInt();

      switch (opcion) {
        case 1 -> System.out.println("Su saldo es de: " + saldo);
        case 2 -> {
          System.out.print("Ingrese el monto a retirar: $");
          double montoRetiro = scanner.nextDouble();

          if (montoRetiro > saldo) {
            System.out.println("Saldo insuficiente");
            continue;
          }

          saldo -= montoRetiro;
          System.out.printf("Su nuevo saldo es de: %.2f\n", saldo);
        }
        case 3 -> {
          System.out.print("Ingrese el monto a depositar: ");
          double montoDeposito = scanner.nextDouble();

          saldo += montoDeposito;
          System.out.printf("Su nuevo saldo es de: %.2f\n", saldo);
        }
        case 9 -> {
          System.out.println("***Gracias por usar nuestros servicios***");
          salir = true;
        }
        default -> System.out.println("La opción seleccionada no existe, intente nuevamente");
      }
    }

    scanner.close();
  }
}
