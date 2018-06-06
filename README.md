[![Build Status](https://travis-ci.org/martinCastello/Inscripcion.svg?branch=master)](https://travis-ci.org/martinCastello/Inscripcion)

Inscripción Materias UNQ

### Integrantes

Nro | Nombre        | Legajo | Mail
----|---------------|--------|------
1   |Giselle Escobar|        |escobargisele1@gmail.com
2   |Martin Castello|        |castellomn94@gmail.com
3   |Susana Lopez   |        |s.mariel.lopez1995@gmail.com
4   |Omar Gomez     |        |eo-gp@hotmail.com

##Backlog
![backlog](https://user-images.githubusercontent.com/31358718/41069803-df3a167a-69c5-11e8-8ac5-bf8bd747ec24.png)

##Burndown chart
![34537605_2219213071437092_6950992741341855744_n](https://user-images.githubusercontent.com/31358718/41069958-89f57956-69c6-11e8-8838-70840cbeb3f8.png)


## Inscripción

El objetivo es implementar parcialmente el modelo de Inscripción de Materias de la Universidad Nacional de Quilmes.

### Pruebas de aceptación

1. 

### Metodología

1. Programación orientada a objetos + ATDD 
2. A la hora de integrar los cambios de varios desarrolladores, utilizar el flujo de trabajo Feature Branch simulando un repositorio privado (branching model + fork).
3. Cada cambio necesita ser integrado con la mayor frecuencia posiblie, utilizando para la verificación de este un servicio de CI (Continous Integration). [1]
4. Se harán pasos cortos para mantener la integración funcionando.

### Pasos

1. Se importó proyecto eis_201801c_tp_grupal para tener insertarle travis(integración continua) sin problemas.
2. Se le dio permiso de acceso a travis para "gradlew" a través de la ejecución de la siguiente sentencia desde la consola: 
    git update-index --chmod=+x gradlew
   La otra opción es en travis agregar: 
    before_install:
    - chmod +x gradlew
   Lo bueno de este tipo de solución no cambia el permiso en su repositorio git, sino que simplemente cambia el tiempo de ejecución de      los permisos en la ejecución.
3. Se estuvo probando travis, para revisar las sentencias que tomaba como validas y que devovía.
4. Se realizó la conexión de la base de datos de manera local. Se descartó el uso de hibernate por su complejidad con travis. 
5. Con la metodología "prueba y error" hicimos andar travis.

### Para tener en cuenta
- bundle para cucumber en travis.

[1]: https://travis-ci.org/
