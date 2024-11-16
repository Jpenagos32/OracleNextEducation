package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.*;
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
        5 - Top 5 mejores series
        6 - Buscar series por categoria
        7 - Buscar series por numero máximo de temporadas
        8 - Buscar series por cantidad exacta de temporadas
                
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
        case 5:
          buscarTop5Series();
          break;
        case 6:
          buscarSeriesPorCategoria();
          break;
        case 7:
          buscarPorMaximoDeTemporadas();
          break;
        case 8:
          buscarPorTemporadasExactas();
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

  private void buscarTop5Series() {
    List<Serie> topSeries = repository.findTop5ByOrderByEvaluacionDesc();
    topSeries.forEach(s -> System.out.println("Serie: " + s.getTitulo() + " Evaluacion: " + s.getEvaluacion()));
  }

  private void buscarSeriesPorCategoria() {
    System.out.println("Escriba el genero/categoria de la serie que desea buscar");
    var genero = teclado.nextLine();
    var categoria = Categoria.fromEspanol(genero);

    List<Serie> seriesPorCategoria = repository.findByGenero(categoria);
    System.out.println("Las series de la categoría " + genero);

    seriesPorCategoria.forEach(System.out::println);

  }

  private void buscarPorMaximoDeTemporadas() {
    System.out.println("Ingrese la cantidad máxima de temporadas de la serie que desea buscar");
    var temporadas = teclado.nextInt();

    List<Serie> seriesPorTemporada = repository.findByTotalTemporadasLessThanEqual(temporadas);
    if (seriesPorTemporada.isEmpty()) {
      System.out.println("No se encontró ninguna serie con " + temporadas + " temporadas o menos");
    } else {
      System.out.println("Las series con un máximo de " + temporadas + " temporadas: ");
      seriesPorTemporada.forEach(System.out::println);
    }

  }

  private void buscarPorTemporadasExactas() {
    System.out.println("Ingrese la cantidad exacta de temporadas de la serie que desea buscar");
    var temporadas = teclado.nextInt();

    List<Serie> totalTemporadas = repository.findByTotalTemporadas(temporadas);

    if (totalTemporadas.isEmpty()) {
      System.out.println("No se encontro ninguna serie con " + temporadas + " temporadas");
    } else {
      System.out.println("Las series que tienen exactamente " + temporadas + " temporadas: ");
      totalTemporadas.forEach(System.out::println);
    }
  }
}