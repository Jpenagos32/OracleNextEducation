package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
  private Scanner teclado = new Scanner(System.in);
  private ConsumoAPI consumoApi = new ConsumoAPI();
  private final String URL_BASE = "https://www.omdbapi.com/?t=";
  private final String API_KEY = "&apikey=4fc7c187";
  private ConvierteDatos conversor = new ConvierteDatos();
  private List<DatosSerie> datosSeries = new ArrayList<>();
  private List<Serie> series;

  private SerieRepository repository;

  public Principal(SerieRepository repository) {
    this.repository = repository;
  }

  public void muestraElMenu() {
    var opcion = -1;
    while (opcion != 0) {
      var menu = """
        1 - Buscar series
        2 - Buscar episodios
        3 - Listar series buscadas
        4 - Buscar series por titulo
        0 - Salir
        """;
      System.out.println(menu);

      opcion = teclado.nextInt();
      teclado.nextLine();

      switch (opcion) {
        case 1:
          buscarSerieWeb();
          break;
        case 2:
          buscarEpisodioPorSerie();
          break;
        case 3:
          mostrarSeriesBuscadas();
          break;
        case 4:
          buscarSeriesPorTitulo();
          break;
        case 0:
          System.out.println("Cerrando la aplicación...");
          break;
        default:
          System.out.println("Opción inválida");
      }
    }
  }

  private void buscarSerieWeb() {
    DatosSerie datos = getDatosSerie();
    Serie serie = new Serie(datos);
    repository.save(serie);
    //datosSeries.add(datos);
    System.out.println(datos);

  }

  private DatosSerie getDatosSerie() {
    System.out.println("Escribe el nombre de la serie que deseas buscar");
    var nombreSerie = teclado.nextLine();
    var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
    DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
    System.out.println(datos.sinopsis());
    return datos;
  }

  private void buscarEpisodioPorSerie() {
    mostrarSeriesBuscadas();
    System.out.println("Escribe el nombre de la serie de la cual quieres ver los episodios");

    var nombreSerie = teclado.nextLine();

    Optional<Serie> serie = series.stream()
      .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
      .findFirst();

    if (serie.isPresent()) {
      var serieEncontrada = serie.get();

      List<DatosTemporadas> temporadas = new ArrayList<>();

      for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
        var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
        DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
        temporadas.add(datosTemporada);
      }
      temporadas.forEach(System.out::println);

      List<Episodio> episodios = temporadas.stream()
        .flatMap(d -> d.episodios().stream().map(e -> new Episodio(d.numero(), e)))
        .collect(Collectors.toList());
      serieEncontrada.setEpisodios(episodios);
      repository.save(serieEncontrada);
    }


  }

  private void mostrarSeriesBuscadas() {
    series = repository.findAll();
    series.stream()
      .sorted(Comparator.comparing(Serie::getGenero))
      .forEach(System.out::println);

  }

  private void buscarSeriesPorTitulo() {
    System.out.println("Escribe el nombre de la serie que deseas buscar");
    var nombreSerie = teclado.nextLine();

    Optional<Serie> serieBuscada = repository.findByTituloContainsIgnoreCase(nombreSerie);

    if (serieBuscada.isPresent()) {
      System.out.println("La serie buscada es: " + serieBuscada.get());
    } else {
      System.out.println("Serie no encontrada");
    }
  }
}