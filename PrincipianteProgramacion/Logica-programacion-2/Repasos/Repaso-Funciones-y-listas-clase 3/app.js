// ? Ejercicio 1
function indiceMasaCorporal() {
  // formula: peso / altura^2
  let peso = document.getElementById('peso')
  let altura = document.getElementById('altura')
  const div = document.getElementById('IMC')

  const resultado = parseFloat(peso.value) / Math.pow(parseFloat(altura.value), 2)

  if (resultado) {
    let respuesta = document.createElement('p')
    // Da la respuesta y aproxima el resultado a solo dos decimales
    respuesta.innerText = `Su Indice de Masa Corporal es ${resultado.toFixed(2)}`
    div.appendChild(respuesta)
  }
  peso.value = ''
  altura.value = ''
}

// ? Ejercicio 2
function factorizarNumero() {
  let numero = document.getElementById('factorizar')
  let p = document.createElement('p')
  let valorNumerico = parseInt(numero.value)
  let resultado = valorNumerico
  const div = document.getElementById('factNumero')

  if (numero.value !== '') {

    if (valorNumerico < 0) {
      p.innerText = 'El resultado es -1'
    } else if (valorNumerico == 0 || valorNumerico == 1) {
      p.innerText = 'El resultado es 1'
    } else {
      while (valorNumerico > 1) {
        valorNumerico--;
        resultado = resultado * valorNumerico
      }
      p.innerText = `El resultado es ${resultado}`
    }
    div.appendChild(p)
    numero.value = ''
  }
}

// ? Ejercicio 3
function conversorMoneda() {
  // precio dolar 4164.45
  const div = document.getElementById('conversorMonedaDiv')
  const monto = document.getElementById('monto')

  let montoNumerico = parseFloat(monto.value)

  const resultado = montoNumerico * 4164.45

  const resultadoLocal = resultado.toLocaleString('es-CO', {
    style: 'currency',
    currency: 'COP',
  });

  if (resultado) {
    const p = document.createElement('p')
    p.innerText = `$${montoNumerico} USD equivalen a ${resultadoLocal} COP`
    div.appendChild(p)
    monto.value = ''
  }

}