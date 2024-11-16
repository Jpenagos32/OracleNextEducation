package com.aluracursos.screenmatch.model;

public enum Categoria {
  ACCION("Action", "Accion"),
  ROMANCE("Romance", "Romance"),
  COMEDIA("Comedy", "Comedia"),
  DRAMA("Drama", "Drama"),
  CRIMEN("Crime", "Crimen");

  private String categoriaOmdb;

  private String categoriaEspanol;

  Categoria(String categoriaOmdb, String categoriaEspanol) {
    this.categoriaOmdb = categoriaOmdb;
    this.categoriaEspanol = categoriaEspanol;
  }

  /*
  * Lo que hace esta funcion es iterar esos valores y rectificar que lo que se le pasa por parametro sea igual
  * al primer valor que está en los enums (para este caso: "Action", "Romance", "Comedy", "Drama", "Crime")
  * */
  public static Categoria fromString(String text) {

    /*
    * del lado izquierdo (Categoria categoria:) es la variable que estamos creando para ir guardando los
    * valores iterados
    *
    * del lado derecho (: Categoria.values()) son los valores declarados dentro de el enum, para este caso son
    * ACCION, ROMANCE, COMEDIA, DRAMA, CRIMEN
    * */
    for (Categoria categoria : Categoria.values()) {
      if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
        return categoria;
      }
    }
    throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
  }

  /*
  * Lo que hace esta funcion es iterar esos valores y rectificar que lo que se le pasa por parametro sea igual
  * al primer valor que está en los enums (para este caso: "Accion", "Romance", "Comedia", "Drama", "Crimen")
  * */
  public static Categoria fromEspanol(String text) {

    /*
     * del lado izquierdo (Categoria categoria:) es la variable que estamos creando para ir guardando los
     * valores iterados
     *
     * del lado derecho (: Categoria.values()) son los valores declarados dentro de el enum, para este caso son
     * ACCION, ROMANCE, COMEDIA, DRAMA, CRIMEN
     * */
    for (Categoria categoria : Categoria.values()) {
      if (categoria.categoriaEspanol.equalsIgnoreCase(text)) {
        return categoria;
      }
    }
    throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
  }

}
