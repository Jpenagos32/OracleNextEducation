package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

// A esto se le llama un DTO que lo que hace es que spring pueda mapear automaticamente
// los datos que vienen desde la petición y convertirlos en un objeto java
public record DatosRegistroMedico(
  // Estas anotaciones vienen por parte de la librería validation
  @NotBlank
  String nombre,

  @NotBlank
    @Email
  String email,

  @NotBlank
    @Pattern(regexp = "\\d{4,50}")
  String documento,

  @NotNull
  Especialidad especialidad,

  @NotNull
    @Valid
  DatosDireccion direccion,

  @NotBlank
  String telefono
) {
}
