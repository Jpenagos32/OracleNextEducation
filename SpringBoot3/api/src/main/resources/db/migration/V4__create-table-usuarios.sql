-- De esta forma podemos crear migraciones que no es más que archivos SQL que utiliza
-- flyway para poder crear nuestras tablas dentro de la base de datos

-- La forma de nombrar los archivos es como se describe en el nombre de este arvchivo

-- V<#Version>__nombre-descriptivo.sql
-- Dentro de estos archivos lo que va es unicamente código SQL

-- Es importante aclarar que mientras se estén realizando cambios dentro de alguno de estos
-- archivos, el proyecto no debe estár corriendo en caso de que se haya olvidado detener el proyecto
-- para poder editar el archivo será necesario correr el siguiente script

-- delete from flyway_schema_history where success = 0;

-- Posteriormente se puede volver a iniciar el proyecto y no debería tener ningun error

create table usuarios(
    id bigint not null auto_increment,
    login varchar(100) not null,
    clave varchar(300) not null,

    primary key(id)
);