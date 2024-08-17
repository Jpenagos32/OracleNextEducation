/*
Debe pedir al usuario responder 3 preguntas:

- ¿Cuál es tu nombre?
- ¿Cuántos años tienes?
- ¿Qué lenguaje de programación estás estudiando?

A medida que se hagan las preguntas, la persona que esté usando el programa debe responder cada una de ellas.

Al final, el sistema mostrará el mensaje:

"Hola [nombre], tienes [edad] años y ya estás aprendiendo [lenguaje]!"
*/

const nombre = prompt('Cual es tu nombre?')
const edad = prompt('Cuantos años tienes?')
const lenguaje = prompt('Que lenguaje de programación estás estudiando?')

alert(`Hola ${nombre}, tienes ${edad} años y ya estás aprendiendo ${lenguaje}!`)

/* 
después de mostrar el mensaje anterior, el programa pregunte:

¿Te gusta estudiar [lenguaje]? Responde con el número 1 para SÍ o 2 para NO.

Y luego, dependiendo de la respuesta, debería mostrar uno de los siguientes mensajes:

1 > ¡Muy bien! Sigue estudiando y tendrás mucho éxito.

2 > Oh, qué pena... ¿Ya intentaste aprender otros lenguajes?
*/
const opcion = prompt(`
  Te gusta estudiar ${lenguaje}?. 
  Responde con las siguientes opciones 
  1 Si.
  2 No.
`)

if (opcion == 1){
  alert('¡Muy bien! Sigue estudiando y tendrás mucho éxito.')
}
else {
  alert('Oh, qué pena... ¿Ya intentaste aprender otros lenguajes?')
}
