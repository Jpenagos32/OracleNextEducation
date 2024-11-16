package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// <Serie, Long> hacen referencia al tipo de objeto y al tipo de dato del ID dentro de dicho objeto
public interface SerieRepository extends JpaRepository<Serie, Long> {
  Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

  List<Serie> findTop5ByOrderByEvaluacionDesc();

  List<Serie> findByGenero(Categoria categoria);

  List<Serie> findByTotalTemporadasLessThanEqual(int cantidad);

  List<Serie> findByTotalTemporadas(int cantidad);

  /*
  * Para realizar las busquedas usando query nativas (SQL)
  * debemos primero agregar la anotacion de @Query pasando como primer parametro (value) la query a ejecutar
  *
  * y como segundo parametro (nativeQuery) debemos indicarle que estaremos usando query nativa poniendolo como true
  *
    @Query(value = "SELECT * FROM series WHERE series.total_temporadas <= 6 AND series.evaluacion >= 7.5", nativeQuery = true)
  * */

  /*
  * Para realizar las busquedas usando JPQL (Java Persistence Query Language)
  *
  * debemos pasarle a la query el nombre de la clase que representa la entidad dentro de la base de datos
  * en lugar de pasarle el nombre de la tabla (en este caso pasamos Serie y le damos el alias de "s")
  *
  * para las condiciones de busqueda debemos pasarle al los parametros que definimos dentro del metodo, usando
  * los : para indicar que hacen referencia a parametros nombrados
  * */
  @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
  List<Serie> seriesPorTemporadaYEvaluacion(int totalTemporadas, Double evaluacion);

  @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
  List<Episodio> episodiosPorNombre(String nombreEpisodio);

  @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5")
  List<Episodio> top5Episodios(Serie serie);
}
