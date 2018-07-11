[![Build Status](https://travis-ci.org/martinCastello/Inscripcion.svg?branch=master)](https://travis-ci.org/martinCastello/Inscripcion)

Inscripción Materias UNQ

### Integrantes

Nro | Nombre        | Legajo | Mail
----|---------------|--------|------
1   |Giselle Escobar|        |escobargisele1@gmail.com
2   |Martin Castello|        |castellomn94@gmail.com
3   |Susana Lopez   |        |s.mariel.lopez1995@gmail.com
4   |Omar Gomez     |        |eo-gp@hotmail.com



### Backlog

![captura de pantalla de 2018-06-26 20-25-26](https://user-images.githubusercontent.com/31372437/41944742-c3d4b3d0-797f-11e8-8d9d-fe4b01cfeff0.png)



### Burndown chart

![captura de pantalla de 2018-07-10 21-58-39](https://user-images.githubusercontent.com/31372437/42545225-04f123cc-848d-11e8-858b-cbf2e204c62d.png)

### Retrospectiva:
30/05
* Agrregar colchon a la estimación por desconocimiento de tecnología.
* Capitalizar el esfuerzo de cada integrante (ascentar el progreso)

06/06
Low:
* Ninguna

High:
* Capitalizamos el esfuerzo de todos.
* Subsanamos las carencias técnicas.
* Nos coordinamos mejor.

13/06
low:
* Falta de tiempo para poder implementar entregable para el usuario

High:
* Articulación de grupo
* Refactor de clases

20/06
Low:
* No se logro nivelar el ritmo de trabajo

High:
* Aumento del flujo de trabajo

27/06
Low:
* Continuamos con el problema de nivelar el ritmo pero, se mejoro 

High:
* Logramos compartir conocimientos para nivelar los mismos.

04/06
Low:
* Pequeña desincronizacion con horarios a la hora de establecer una comunicacion 

High:
* Conseguimos aumentar el ritmo de trabajo.

11/06
Low:
* No se llego con el tiempo necesario (sprints) para cuminar el trabajo

High:
* Se volvio al ritmo de trabajo normal para llevarlo constante

## Inscripción

El objetivo es implementar parcialmente el modelo de Inscripción de Materias de la Universidad Nacional de Quilmes.

### Pruebas de aceptación

1. 

### Metodología

1. A la hora de integrar los cambios de varios desarrolladores, utilizar el flujo de trabajo Feature Branch simulando un repositorio privado (branching model + fork).
2. Cada cambio necesita ser integrado con la mayor frecuencia posiblie, utilizando para la verificación de este un servicio de CI (Continous Integration). [1]
3. Se harán pasos cortos para mantener la integración funcionando.

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
