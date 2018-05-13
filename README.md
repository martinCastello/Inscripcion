### Pacman

El objetivo de este dojo es implementar parcialmente el modelo del juego [Pacman][2] aplicando la técnica ATDD e integrando los cambios de manera frecuente e iterativa. Para eso implementar un CI (preferentemente [Travis][1]).

### Pruebas de aceptación

1. Pacman come un biscuit se vuelve más gordo (suma puntos).
2. Pacman come una fruta se vuelve más gordo (suma puntos).
3. Pacman choca contra un fantasma y muere.
4. Pacman come un pellet y los fantasmas se debilitan.
5. Pacman choca contra un fantasma debilitado y no muero. Adicionalmente la digestión es el fantasma sin cuerpo.
6. Pacman choca contra un fantasma sin cuerpo y no muere.

7. Pacman como un maracuya y vuela evitando a los fantansmas. Este efecto se prolonga el resto de la partida.

### Metodología

Programación orientada a objetos + ATDD

### Objetivos

1. Crear un repositorio público con cualquier servicio de versionado de fuentes (Bitbucket, GitHub, etc.)
2. El desarrollo se realiza utilizando la técnica ATDD
3. A la hora de integrar los cambios de varios desarrolladores, utilizar el flujo de trabajo Feature Branch simulando un repositorio privado (branching model + fork).
4. Cada cambio necesita ser integrado con la mayor frecuencia posiblie, utilizando para la verificación de este un servicio de CI (Continous Integration).

[1]: https://travis-ci.org/
[2]: https://en.wikipedia.org/wiki/Pac-Man
