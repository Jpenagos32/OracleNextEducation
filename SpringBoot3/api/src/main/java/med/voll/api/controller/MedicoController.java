package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public List<DatosListadoMedico> listadoMedicos(){
    return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
  }
}
