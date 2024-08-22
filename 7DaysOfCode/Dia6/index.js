/* 
Deberás crear la opción de eliminar algún elemento de la lista, que se mostrará junto con la pregunta: “¿deseas añadir un alimento a la lista de compras?”.

A partir de ahí, si la persona elige esa opción, el programa imprimirá los elementos presentes en la lista actual, y la persona deberá escribir cuál de ellos desea eliminar.

Después de eso, el programa eliminará el elemento de la lista e imprimirá la confirmación de que el elemento realmente ya no está allí.

Finalmente, el programa volverá al ciclo inicial de preguntas.

Si, al intentar eliminar el elemento, este no se encuentra en la lista, deberás mostrar un mensaje advirtiendo de ello.

Por ejemplo: “¡No fue posible encontrar el elemento en la lista!”.

Recuerda que la opción de eliminar un elemento solo deberá estar disponible a partir del momento en que exista al menos un elemento en la lista de compras.
*/

let salir = false

let listaDeCompras = [] // {id: 1, alimento: 'naranja', tipo: 'fruta'}

let id = 1

while (!salir) {
  let alimentoLista = prompt('Seleccione una de las siguientes opciones: \n1. Agregar alimento\n2. Eliminar alimento\n3. Salir')

  if (alimentoLista == 1) {
    let alimento = prompt('que alimento desea agregar?')
    let categoriaAlimento = parseInt(prompt(`A que categoria pertenece ${alimento}?\n1. Frutas\n2. Lácteos\n3. Congelados\n4. Dulces\n5. Vegetales`))

    switch (categoriaAlimento) {
      case 1:
        listaDeCompras.push({ id, alimento, tipo: 'frutas' })
        break;

      case 2:
        listaDeCompras.push({ id, alimento, tipo: 'lácteos' })
        break;

      case 3:
        listaDeCompras.push({ id, alimento, tipo: 'congelados' })
        break;

      case 4:
        listaDeCompras.push({ id, alimento, tipo: 'dulces' })
        break;

      case 5:
        listaDeCompras.push({ id, alimento, tipo: 'vegetales' })
        break;

      default:
        alert('La opción seleccionada no es valida, intente de nuevo')
        break;
    }

  }
  else if (alimentoLista == 2) {
    let list = listaDeCompras.map(element => `${element.id}. ${element.alimento}`).join('\n')
    let elementoEliminar = parseInt(prompt(`Seleccione el elemento que desea eliminar: \n${list}`))

    let found = listaDeCompras.find(el => el.id == elementoEliminar)

    if (!found) {
      alert('No se encontró el elemento')
    }
    else {
      listaDeCompras = listaDeCompras.filter(element => parseInt(element.id) != parseInt(elementoEliminar))
    }

  }
  else if (alimentoLista == 3) {
    let frutas, lacteos, congelados, dulces, vegetales
    frutas = listaDeCompras.filter(fruta => fruta.tipo == 'frutas').map(fruta => fruta.alimento).join('\n\t ')
    lacteos = listaDeCompras.filter(lacteo => lacteo.tipo == 'lácteos').map(lacteo => lacteo.alimento).join('\n\t ')
    congelados = listaDeCompras.filter(congelado => congelado.tipo == 'congelados').map(congelado => congelado.alimento).join('\n\t ')
    dulces = listaDeCompras.filter(dulce => dulce.tipo == 'dulces').map(dulce => dulce.alimento).join('\n\t ')
    vegetales = listaDeCompras.filter(vegetal => vegetal.tipo == 'vegetales').map(vegetal => vegetal.alimento).join('\n\t ')


    alert(`Lista de compras:
Frutas: \n\t ${frutas}
Lacteos: \n\t ${lacteos}
Congelados: \n\t ${congelados}
Dulces: \n\t ${dulces}
Vegetales: \n\t ${vegetales}`)
    salir = true
  }
  else {
    alert('La opción seleccionada no existe, porfavor intente de nuevo')
  }
  id++
}