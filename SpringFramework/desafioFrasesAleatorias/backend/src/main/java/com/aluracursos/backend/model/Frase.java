package com.aluracursos.backend.model;

import jakarta.persistence.*;

/*
* Indicamos a jpa que esto es una entidad de la base de datos usando la anotacion @Entity
*
* Le indicamos el nombre de la tabla con la anotacion @Table(name = "frases")
* */
@Entity
@Table(name = "frases" )
public class Frase {
  // Indicamos que es la llave primaria la cual es un id autoincremental
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String frase;
  private String personaje;
  private String poster;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getFrase() {
    return frase;
  }

  public void setFrase(String frase) {
    this.frase = frase;
  }

  public String getPersonaje() {
    return personaje;
  }

  public void setPersonaje(String personaje) {
    this.personaje = personaje;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }
}
