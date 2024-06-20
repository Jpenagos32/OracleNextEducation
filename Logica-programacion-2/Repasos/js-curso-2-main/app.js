const title = document.querySelector('h1')
title.innerHTML = 'Hora del Desafio';

function consoleButton() {
  console.log('El botón fue clickado')
}

function promptButton() {
  const ciudad = prompt('indique una ciudad')
  alert(`Estuve en ${ciudad} y me acordé de ti`)
}

function alertButton() {
  alert('Yo amo JS')
}

function sumaButton() {
  const num1 = parseInt(prompt('Ingrese el primer número'))
  const num2 = parseInt(prompt('Ingrese el segundo número'));
  const result = num1 + num2
  alert(`El resultado de la suma es: ${result}`)
}