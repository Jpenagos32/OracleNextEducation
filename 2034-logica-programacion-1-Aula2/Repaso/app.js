const ingreso = prompt('En que dia de la semana estamos')

if (ingreso.toLowerCase() == 'sabado' || ingreso.toLowerCase() == 'domingo') {
  alert('Buen fin de semana')
} else {
  alert('Buena semana')
}