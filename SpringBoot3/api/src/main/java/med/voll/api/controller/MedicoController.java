package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
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
  public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion){
    // la combinacion del tipo de retorno "Page" junto con el parametro "Pageable" y lo que retorna genera una páginación
    return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
  }
}
