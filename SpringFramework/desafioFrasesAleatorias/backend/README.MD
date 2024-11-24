# Como inciar un proyecto
1. Agregar las dependencias necesarias
   - spring web
   - jpa
   - postgres
   - spring dev tools

2. Agregar los datos necesarios al `application.properties`
   ```
   spring.datasource.url=jdbc:postgresql://localhost/frases_aleatorias
   spring.datasource.username=postgresUsername
   spring.datasource.password=postgresPassword
   spring.datasource.driver-class-name=org.postgresql.Driver
   hibernate.dialect=org.hibernate.dialect.HSQLDialect

   spring.jpa.show-sql=true
   spring.jpa.format-sql=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Para poder crear las tablas dentro de la base de datos, debemos crear los modelos tal como están creados en el archivo `model.Frases.java`
   - Este será el modelo, dentro del modelo además de todo, debemos definir los getters y setters de las propiedades.

4. Crear los controladores.
   - El controlador requiere un servicio(FraseService)
     - El controlador en una primera instancia siempre debe regresar un DTO
   - El servicio requiere de un repostiorio(FraseRepository)
     - En el repositorio se encuentran los "query"
   - El servicio tambien requiere de un DTO (Data Transfer Object) que no es más que un record que contiene las mismas propiedades del modelo
     - Este DTO lo que hace es convertir los datos para que se puedan mostrar en el navegador
