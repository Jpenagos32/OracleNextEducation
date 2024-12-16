package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ES MUY IMPORTANTE VERIFICAR LA VERSION DE LOMBOK, DE LO CONTRARIO NO FUNCIONA


// esto hace parte de lombok y lo que hace es generar los getters al momento de compilar
@Getter

// parte de lombok, genera un constructor sin atributos
@NoArgsConstructor

// Parte de lombok, genera un constructor con todos los atributos
@AllArgsConstructor
@Embeddable
public class Direccion {

  private String calle;
  private String numero;
  private String complemento;
  private String distrito;
  private String ciudad;


  public Direccion(DatosDireccion direccion) {
    this.calle = direccion.calle();
    this.numero = direccion.numero();
    this.distrito = direccion.distrito();
    this.complemento = direccion.complemento();
    this.ciudad = direccion.ciudad();
  }

  public Direccion actualizarDatos(DatosDireccion direccion) {
    this.calle = direccion.calle();
    this.numero = direccion.numero();
    this.distrito = direccion.distrito();
    this.complemento = direccion.complemento();
    this.ciudad = direccion.ciudad();
    return this;
  }
}
