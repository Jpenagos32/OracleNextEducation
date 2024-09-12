/* 
debes crear un programa en Javascript que pregunte si deseas agregar un alimento a tu lista de compras, y debes poder responder con "sí" o "no".

A continuación, preguntará qué alimento deseas agregar, y escribirás su nombre, como por ejemplo "zanahoria".

Después, deberá preguntar en qué categoría se encaja ese alimento, con algunas opciones ya predefinidas, como frutas, lácteos, congelados, dulces y lo que más creas interesante. Así podrás separar todo en su respectivo grupo.

Por último, en caso de que ya no quieras agregar nada más a la lista de compras y respondas "no" a la primera pregunta, se mostrará una lista con todos los ítems agrupados, de la siguiente manera:

Si añades a tu lista:

banana, leche en polvo, tomate, leche vegetal, chicle, gominola, manzana, uva, aguacate y leche de vaca.

El programa debería imprimir, por ejemplo:

Lista de compras:

Frutas: banana, tomate, manzana, uva, aguacate

Lácteos: leche vegetal, leche de vaca, leche en polvo

Congelados: 

Dulces: chicle y gominola
*/

let salir = false
let listaDeCompras = {
  frutas: [],
  lacteos: [],
  congelados: [],
  dulces: [],
  vegetales: []
}

while (!salir) {
  let alimentoLista = prompt('Desea agregar un alimento a su lista de compras?\n1. Si\n2. No')

  if (alimentoLista == 1) {
    let alimento = prompt('que alimento desea agregar?')
    let categoriaAlimento = parseInt(prompt(`A que categoria pertenece ${alimento}?\n1. Frutas\n2. Lácteos\n3. Congelados\n4. Dulces\n5. Vegetales`))

    switch (categoriaAlimento) {
      case 1:
        listaDeCompras.frutas.push(alimento)
        break;

      case 2:
        listaDeCompras.lacteos.push(alimento)
        break;

      case 3:
        listaDeCompras.congelados.push(alimento)
        break;

      case 4:
        listaDeCompras.dulces.push(alimento)
        break;

      case 5:
        listaDeCompras.vegetales.push(alimento)
        break;

      default:
        alert('La opción seleccionada no es valida, intente de nuevo')
        break;
    }

  }
  else if (alimentoLista == 2) {
    alert(`Lista de compras:
  Frutas: ${listaDeCompras.frutas.join(', ')}
  Lacteos: ${listaDeCompras.lacteos.join(', ')}
  Congelados: ${listaDeCompras.congelados.join(', ')}
  Dulces: ${listaDeCompras.dulces.join(', ')}
  Vegetales: ${listaDeCompras.vegetales.join(', ')}`)
    salir = true
  }
  else {
    alert('La opción seleccionada no existe, porfavor intente de nuevo')
  }
}