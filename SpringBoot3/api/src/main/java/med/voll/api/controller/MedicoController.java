package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

  // Esta anotacion lo que hace es buscar automaticamente MedicoRepository e instanciarlo o "inyectarlo"
  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  // Con la anotacion @Valid lo que hará será aplicar las validaciones que están dentro del DTO DatosRegistroMedico
  public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                                                              UriComponentsBuilder uriComponentsBuilder) {
    Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
    DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(
      medico.getId(),
      medico.getNombre(),
      medico.getEmail(),
      medico.getTelefono(),
      medico.getEspecialidad().toString(),
      new DatosDireccion(
        medico.getDireccion().getCalle(),
        medico.getDireccion().getDistrito(),
        medico.getDireccion().getCiudad(),
        medico.getDireccion().getNumero(),
        medico.getDireccion().getComplemento()
      )
    );

    URI url =uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
    // Retornar codigo 201 created
    // URL donde encontrar al médico: http://localhost:8080/medicos/xx
    return ResponseEntity.created(url).body(datosRespuestaMedico);
  }

  @GetMapping
  // Con la anotación @PageableDefault podemos cambiar los parametros por defecto de la api de paginación
  public ResponseEntity<Page<DatosListadoMedico>>  listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
    // la combinacion del tipo de retorno "Page" junto con el parametro "Pageable" y lo que retorna genera una páginación
    return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));
  }

  @PutMapping
  @Transactional
  // esta anotacion realiza un commit en la base de datos para que se guarden los datos, en caso de error hará un rollback
  public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
    Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
    medico.actualizarDatos(datosActualizarMedico);

    return ResponseEntity.ok(new DatosRespuestaMedico(
      medico.getId(),
      medico.getNombre(),
      medico.getEmail(),
      medico.getTelefono(),
      medico.getEspecialidad().toString(),
      new DatosDireccion(
        medico.getDireccion().getCalle(),
        medico.getDireccion().getDistrito(),
        medico.getDireccion().getCiudad(),
        medico.getDireccion().getNumero(),
        medico.getDireccion().getComplemento()
      )
    ));
  }

  @DeleteMapping("/{id}") // entre las llaves indicamos que ahí va una variable /medicos/{id}
  @Transactional
  public ResponseEntity eliminarMedico(@PathVariable Long id) { // la anotación @PathVariable indica que el id viene dentro de la ruta
    Medico medico = medicoRepository.getReferenceById(id);
    // Método usado para poder realizar un delete real
    // medicoRepository.delete(medico);

    // método usado para un borrado lógico
    medico.desactivarMedico();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}") // entre las llaves indicamos que ahí va una variable /medicos/{id}
  public ResponseEntity<DatosRespuestaMedico> RetornaDatosMedico(@PathVariable Long id) { // la anotación @PathVariable indica que el id viene dentro de la ruta
    Medico medico = medicoRepository.getReferenceById(id);

    var datosMedicos = new DatosRespuestaMedico(
      medico.getId(),
      medico.getNombre(),
      medico.getEmail(),
      medico.getTelefono(),
      medico.getEspecialidad().toString(),
      new DatosDireccion(
        medico.getDireccion().getCalle(),
        medico.getDireccion().getDistrito(),
        medico.getDireccion().getCiudad(),
        medico.getDireccion().getNumero(),
        medico.getDireccion().getComplemento()
      )
    );

    return ResponseEntity.ok(datosMedicos);
  }
}
