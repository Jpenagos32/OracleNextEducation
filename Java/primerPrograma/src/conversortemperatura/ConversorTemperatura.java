package conversortemperatura;

public class ConversorTemperatura {
  public static void main(String[] args) {
    int celsius = 10;
    int fahrenheit = 45;

    double resultado = (celsius * 1.8) + 32;

    System.out.println("resultado = " + resultado);
  }
}
