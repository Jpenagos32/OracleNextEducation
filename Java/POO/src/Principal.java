import com.julianpenagos.sceenmatch.calculos.CalculadoraDeTiempo;
import com.julianpenagos.sceenmatch.calculos.FiltroRecomendacion;
import com.julianpenagos.sceenmatch.modelos.Episodio;
import com.julianpenagos.sceenmatch.modelos.Pelicula;
import com.julianpenagos.sceenmatch.modelos.Serie;

public class Principal {
  public static void main(String[] args) {
    Pelicula miPelicula = new Pelicula();
    miPelicula.setNombre("Encanto");
    miPelicula.setFechaDeLanzamiento(2021);
    miPelicula.setDuracionEnMinutos(120);
    miPelicula.setIncluidoEnElPlan(true);
    miPelicula.mostrarPelicula();
    miPelicula.evalua(10);
    miPelicula.evalua(10);

    System.out.println("Total de evaluaciones: " + miPelicula.getTotalEvaluaciones());
    System.out.println("Puntuación media de la pelicula: " + miPelicula.calculaMedia());

    Serie casaDragon = new Serie();
    casaDragon.setNombre("La casa del Dragón");
    casaDragon.setFechaDeLanzamiento(2022);
    casaDragon.setTemporadas(1);
    casaDragon.setMinutosPorEpisodio(50);
    casaDragon.setEpisodiosPorTemporada(10);
    casaDragon.muestraFichaTecnica();
    System.out.println(casaDragon.getDuracionEnMinutos());

    CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();

    calculadora.incluye(miPelicula);
    calculadora.incluye(casaDragon);
    System.out.println(calculadora.getTiempoTotal());

    FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
    filtroRecomendacion.filtra(miPelicula);

    Episodio episodio = new Episodio();
    episodio.setNumero(1);
    episodio.setNombre("La casa no se que");
    episodio.setSerie(casaDragon);
    episodio.setTotalVisualizaciones(50);

    filtroRecomendacion.filtra(episodio);

  }
}
