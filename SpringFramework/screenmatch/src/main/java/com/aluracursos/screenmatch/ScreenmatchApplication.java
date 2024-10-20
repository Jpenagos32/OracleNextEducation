package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodioRecord;
import com.aluracursos.screenmatch.model.DatosSerieRecord;
import com.aluracursos.screenmatch.model.DatosTemporadasRecord;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ScreenmatchApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var consumoApi = new ConsumoAPI();
    var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&apikey=1e57290d");
    // System.out.println(json);

    ConvierteDatos conversor = new ConvierteDatos();

    var datos = conversor.obtenerDatos(json, DatosSerieRecord.class);
    System.out.println(datos);

    json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&Season=1&episode=1&apikey=1e57290d");

    DatosEpisodioRecord episodios = conversor.obtenerDatos(json, DatosEpisodioRecord.class);
    System.out.println(episodios);

    List<DatosTemporadasRecord> temporadas = new ArrayList<>();

    for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
      json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&Season=" + i + "&apikey=1e57290d");
      var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadasRecord.class);
      temporadas.add(datosTemporadas);
    }
    
    temporadas.forEach(System.out::println);
  }
}
