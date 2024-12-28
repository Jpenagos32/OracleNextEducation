package med.voll.api.domain.consulta.validaciones.reserva;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorFueraHorarioConsultas implements ValidadorDeConsultas {

  public void validar(DatosReservaConsulta datos){
    var fechaConsulta = datos.fecha();
    var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var horarioAntesDeAperturaClinica = fechaConsulta.getHour() < 7;
    var horarioDespuesDeCierreClinica = fechaConsulta.getHour() > 18;
    if (domingo || horarioDespuesDeCierreClinica || horarioAntesDeAperturaClinica){
      throw new ValidacionException("Horario seleccionado fuera del horario de atnedimiento de la clínica");
    }
  }
}
