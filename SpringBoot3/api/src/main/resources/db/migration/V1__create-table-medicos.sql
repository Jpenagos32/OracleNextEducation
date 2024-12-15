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

create table medicos(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    documento varchar(50) not null unique,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    distrito varchar(100) not null,
    complemento varchar(100),
    numero varchar(20),
    ciudad varchar(100) not null,

    primary key(id)
);