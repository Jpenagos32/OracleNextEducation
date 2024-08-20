/* 
Debes crear un pequeño programa que comience con un valor específico predefinido entre 0 y 10 para el número que vas a adivinar (por ejemplo, el 7).

A continuación, el programa te preguntará cuál es el valor que deseas adivinar y, si aciertas, te felicitará. Si te equivocas, te dará 2 intentos más.

Al final, si no aciertas en ninguno de los intentos, imprimirá cuál era el número inicial.

Después de que el programa esté funcionando, intenta usar un número aleatorio en lugar de uno predefinido.
*/

let numeroAdivinar = Math.floor(Math.random() * 10) + 1

let contador = 1

let salir = false

while (!salir) {
  let opcion = prompt(`Oportunidad ${contador} de 3 para adivinar un número entre 1 y 10: `)
  if (opcion == numeroAdivinar) {
    alert('Felicidades adivinaste el número')
    salir = true
  }

  else if (contador == 3) {
    alert(`El número era ${numeroAdivinar}, perdiste :(`)
    salir = true
  }

  contador++
}