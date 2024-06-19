const ul = document.getElementById('lista')
let contador = 1;

while (contador <= 10) {
  const li = document.createElement('li')
  li.appendChild(document.createTextNode(contador))
  ul.appendChild(li)
  contador++;
}
