# Prueba Técnica Java Avanzado HACK A BOSS

##### Juan Manuel Gómez Wals

## Instrucciones para su uso

1. Se debe clonar éste mismo repositorio.

2. Iniciamos nuestro SGBBDD y crear la base de datos "turnos".

3. Importamos nuestros archivos turnos_ciudadano.sql y turnos_turno.sql a nuestra base de datos y se crearán tanto las columnas como las filas guardadas en ellos.

4. Iniciamos nuestro proyecto y verificamos que funciona correctamente.

## Ejecución

El programa consta de un menú que nos indica las opciones a elegir en las cuales tendremos diferentes opciones para interactuar con ciudadanos y turnos.

## Acciones

- Se pueden añadir ciudadanos y turnos a la BBDD.

- Se puede modificar el estado de los turnos ya registrados en la BBDD.

- Se pueden recoger todos los registros de ciudadanos en la BBDD así como de turnos, que podrán ser mostrados en base a su fecha y su estado.

- Se pueden eliminar tanto ciudadanos como turnos de la BBDD.

## Supuestos

- Suponemos que al crear o eliminar ciudadanos o turnos, el usuario rellena todos los campos corréctamente.

- Suponemos que un turno no se puede buscar sin antes asignarlo a un ciudadano.

## Tecnologías usadas

> Lenguaje -> Java (JDK 17)

> Persistencia -> EclipseLink (JPA 2.1)

> IDE -> NetBeans (17)