/* 
Tu desafío de hoy es crear los destinos posibles de un juego, en el que el usuario pueda elegir:

Si quiere seguir hacia el área de Front-End o seguir hacia el área de Back-End.

Si está en el área de Front-End, si quiere aprender React o aprender Vue. Si está en el área de Back-End, podrá aprender C# o aprender Java.

Después, independientemente de las elecciones anteriores, el usuario podrá elegir entre seguir especializándose en el área elegida o desarrollarse para convertirse en Fullstack. Debes mostrar en pantalla un mensaje específico para cada elección.

Finalmente, pregunta en qué tecnologías le gustaría a la persona especializarse o conocer. Aquí, la persona puede responder N tecnologías, una a la vez. Entonces, mientras continúe respondiendo **ok** a la pregunta: "¿Hay alguna otra tecnología que te gustaría aprender?", sigue presentando el Prompt, para que complete el nombre de la tecnología en cuestión. Y, justo después, presenta un mensaje comentando algo sobre la tecnología ingresada.

Lo importante es que la persona que esté jugando siempre pueda elegir qué decisión tomar para aprender y desarrollarse en el área de programación.

Además, también es esencial que, al final del juego, pueda ingresar tantas tecnologías como desee en la lista de aprendizaje.
*/

let tecnologia
let areaText
let salir = false

const nombre = prompt('Ingresa tu nombre:')

while (!salir) {

  const area = prompt(`En que te interesa especializarte:
  1. Front-end
  2. Back-end`)

  if (area == 1) {
    tecnologia = prompt(`Cuál de las tecnologías te intereza aprender
  1. React.
  2. Vue`)
    areaText = 'Front-end'
    salir = true
  } else if (area == 2) {
    tecnologia = prompt(`Cuál de las tecnologías te intereza aprender
  1. C#.
  2. Java`)
    areaText = 'Back-end'
    salir = true
  } else {
    alert('Opcion invalida, intentalo de nuevo')
  }
}

salir = false
let especializacionText

while (!salir) {

  const especializacion = prompt(`Te gustaria:
  1. Especializarte en el area elegida.
  2. Convertirte en FullStack.`)

  if (especializacion == 1) {
    especializacionText =  `${areaText}`
    alert(`Excelente Serás un ${areaText} experto`)
    salir = true
  } else if (especializacion == 2) {
    especializacionText = 'Fullstack'
    alert('Muy bien tendrás conocimientos extensos sobre la programación')
    salir = true
  } else {
    alert('Opcion inválida, intentalo de nuevo')
  }
}

salir = false
let lenguaje
let arrayTecnologias = []

while (!salir) {
  lenguaje = prompt(`En que teconologías te gustaría especializarte?: 
  1. Agregar.
  2. Salir`)

  if (lenguaje == 1) {
    arrayTecnologias.push(prompt('Ingresa el nombre de la tecnología/lenguaje en el que te quieres especializar'))
  } else if (lenguaje == 2) {
    mostrarMensaje()
    salir = true
  } else {
    alert('Opción inválida, intenta de nuevo')
  }
}

function mostrarMensaje() {
  h1(`Hola ${nombre} Bienvenido`)

  h2('Aquí tienes tus respuestas')

  p(`Quieres aprender: ${areaText}`)

  p(`Te especializarás en: ${especializacionText}`)

  p(`Las tecnologías que quieres estudiar son: ${arrayTecnologias.join(', ')}`)
}

function h1(text) {
  const titulo = document.createElement('h1')
  titulo.innerText = text
  document.body.appendChild(titulo)
}

function p(text) {
  const para = document.createElement('p')
  para.innerText = text
  document.body.appendChild(para)
}

function h2(text) {
  const subt = document.createElement('h2')
  subt.innerText = text
  document.body.appendChild(subt)
}