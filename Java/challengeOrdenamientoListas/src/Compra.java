public class Compra implements Comparable <Compra> {
  private double valor;
  private String descripcion;

  public Compra(double valor, String descripcion) {
    this.valor = valor;
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Compra{");
    sb.append("valor=").append(valor);
    sb.append(", descripcion='").append(descripcion).append('\'');
    sb.append('}');
    return sb.toString();
  }

  //   Getters
  public double getValor() {
    return valor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  @Override
  public int compareTo(Compra otraCompra) {
    return Double.compare(this.valor, otraCompra.getValor());
  }
}
