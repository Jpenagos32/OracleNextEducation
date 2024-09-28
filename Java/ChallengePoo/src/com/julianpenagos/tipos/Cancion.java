package com.julianpenagos.tipos;

public class Cancion extends Audio {
  private String album;
  private String artista;
  private String genero;

  @Override
  public int getClasificacion() {
    if (getTotalDeMeGusta() > 5000) {
      return 8;
    } else {
      return 4;
    }
  };

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public String getArtista() {
    return artista;
  }

  public void setArtista(String artista) {
    this.artista = artista;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

}
