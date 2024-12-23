package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

// A esto se le llama un DTO que lo que hace es que spring pueda mapear automaticamente
// los datos que vienen desde la petición y convertirlos en un objeto java
public record DatosDireccion(
  @NotBlank
  String calle,

  @NotBlank
  String distrito,

  @NotBlank
  String ciudad,

  @NotBlank
  String numero,

  @NotBlank
  String complemento
) {
}
