function suma(a, b) {
  if (isNaN(a) || isNaN(b)) {
    return 'Debe ingresar unicamente números'
  }
  else {
    return `El resultado de la suma es ${a + b}` 
  }
}

function resta(a, b) {
  if (isNaN(a) || isNaN(b)) {
    return 'Debe ingresar unicamente números'
  }
  else {
    return `El resultado de la resta es ${a - b}`
  }
}

function multiplicacion(a, b) {
  if (isNaN(a) || isNaN(b)) {
    return 'Debe ingresar unicamente números'
  }
  else {
    return `El resultado de la multiplicación es ${a * b}`
  }
}

function division(a, b) {
  if (isNaN(a) || isNaN(b)) {
    return 'Debe ingresar unicamente números'
  }
  else if (b == 0) {
    return 'No se puede dividir entre 0'
  }
  else {
    return `El resultado de la división es ${a / b}`
  }

}