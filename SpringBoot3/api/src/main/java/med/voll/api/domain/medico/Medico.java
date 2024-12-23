package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

// ES MUY IMPORTANTE VERIFICAR LA VERSION DE LOMBOK, DE LO CONTRARIO NO FUNCIONA

@AllArgsConstructor // Lombok
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String email;
  private String documento;
  private String telefono;
  private Boolean activo;

  @Enumerated(EnumType.STRING)
  private Especialidad especialidad;

  @Embedded
  private Direccion direccion;

  public Medico(DatosRegistroMedico datosRegistroMedico) {
    this.nombre = datosRegistroMedico.nombre();
    this.email = datosRegistroMedico.email();
    this.documento = datosRegistroMedico.documento();
    this.especialidad = datosRegistroMedico.especialidad();
    this.direccion = new Direccion(datosRegistroMedico.direccion());
    this.telefono = datosRegistroMedico.telefono();
    this.activo = true;
  }

  public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
    if (datosActualizarMedico.nombre() != null) {
      this.nombre = datosActualizarMedico.nombre();
    }

    if (datosActualizarMedico.documento() != null) {
      this.documento = datosActualizarMedico.documento();
    }

    if (datosActualizarMedico.direccion() != null) {
      this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
    }

  }

  public void desactivarMedico() {
    this.activo = false;
  }
}
