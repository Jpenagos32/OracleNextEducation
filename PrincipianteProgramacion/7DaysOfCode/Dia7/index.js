/* 
crea tu propia calculadora, pero con un detalle muy importante: cada operación debe ser una función diferente en tu código.

Primero, la persona debe elegir una opción de operación impresa por el programa en la pantalla.

Luego, debe ingresar los dos valores que desea utilizar, y el programa imprimirá el resultado de la operación en cuestión.

Las opciones disponibles deben ser: suma, resta, multiplicación, división, y salir. En esta última, el programa debe detenerse y mostrar un mensaje "Hasta la próxima".
*/

let salir = false

while (!salir) {
  const opcion = parseInt(prompt('Seleccione la operación que desea realizar:\n1. Suma\n2. Resta\n3. Multiplicación\n4. División\n5. Salir'))
  let num1, num2
  

  switch (opcion) {
    case 1:
      num1 = parseFloat(prompt('Ingrese el primer número'))
      num2 = parseFloat(prompt('Ingrese el segundo número'))
      alert(suma(num1, num2))
      
      break

    case 2:
      num1 = parseFloat(prompt('Ingrese el primer número'))
      num2 = parseFloat(prompt('Ingrese el segundo número'))
      alert(resta(num1, num2))
      break

    case 3:
      num1 = parseFloat(prompt('Ingrese el primer número'))
      num2 = parseFloat(prompt('Ingrese el segundo número'))
      alert(multiplicacion(num1, num2))
      break

    case 4:
      num1 = parseFloat(prompt('Ingrese el primer número'))
      num2 = parseFloat(prompt('Ingrese el segundo número'))
      alert(division(num1, num2))
      break

    case 5:
      alert("Hasta la próxima")
      salir = true
      break

    default:
      alert('La opción seleccionada no existe, intente de nuevo')
      break
  }
}