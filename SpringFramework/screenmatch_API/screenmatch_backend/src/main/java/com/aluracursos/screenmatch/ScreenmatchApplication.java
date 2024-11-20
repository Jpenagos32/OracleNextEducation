package com.aluracursos.screenmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication {

  /*
  * Para hacer que la aplicacion se reinice cada vez que detecte un cambio necesitamos la dependencia de
  * spring-boot-devtools
  *
  * despues de instalar la dependencia debemos ir a:
  * settings->build,Execution,Deployment->Compiler y activamos la opcion que dice "Build project automatically"
  *
  * Despues debemos ir a:
  * settings->Advanced settings y activamos la opcion "Allow auto-make to start even if developed application is currently running"
  *
  * aplicamos los cambios y listo
  * */
  public static void main(String[] args) {
    SpringApplication.run(ScreenmatchApplication.class, args);
  }
}
