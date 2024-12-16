package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

  // Esta anotacion lo que hace es buscar automaticamente MedicoRepository e instanciarlo o "inyectarlo"
  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  // Con la anotacion @Valid lo que hará será aplicar las validaciones que están dentro del DTO DatosRegistroMedico
  public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
    medicoRepository.save(new Medico(datosRegistroMedico));
  }

  @GetMapping
  // Con la anotación @PageableDefault podemos cambiar los parametros por defecto de la api de paginación
  public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
    // la combinacion del tipo de retorno "Page" junto con el parametro "Pageable" y lo que retorna genera una páginación
    return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
  }

  @PutMapping
  @Transactional
  // esta anotacion realiza un commit en la base de datos para que se guarden los datos, en caso de error hará un rollback
  public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
    Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
    medico.actualizarDatos(datosActualizarMedico);
  }

  @DeleteMapping("/{id}") // entre las llaves indicamos que ahí va una variable /medicos/{id}
  @Transactional
  public void eliminarMedico(@PathVariable Long id) { // la anotación @PathVariable indica que el id viene dentro de la ruta
    Medico medico = medicoRepository.getReferenceById(id);
    // Método usado para poder realizar un delete real
    // medicoRepository.delete(medico);

    // método usado para un borrado lógico
    medico.desactivarMedico();
  }
}
