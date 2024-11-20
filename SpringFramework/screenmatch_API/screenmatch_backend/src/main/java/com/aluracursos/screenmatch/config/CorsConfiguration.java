package com.aluracursos.screenmatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta anotacion ayuda a indicar que esta clase es una clase de configuracion
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry){
    // Configuracion necesaria para arreglar el problema de CORS
    registry.addMapping("/**")
      .allowedOrigins("http://127.0.0.1:5500")
      .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
  }
}
