# Tarea: Modularización de Gestión de Estudiantes
**Estudiante:** Fátima Jacinta Montoya Aguilar

Este repositorio contiene la evolución de un programa de gestión de notas, transformado de un código lineal a una estructura modular siguiendo principios de Clean Code.

## 1. Análisis del Programa Original
El código inicial presentaba una estructura monolítica dentro del método `main`. Esto dificultaba la lectura, el mantenimiento y la escalabilidad, ya que cualquier error en la entrada de datos detenía por completo la ejecución del sistema.

## 2. Decisiones de Modularización
Para mejorar la calidad del software, se fragmentó la lógica en métodos estáticos independientes:
* **`obtenerCantidadEstudiantes`**: Centraliza la entrada inicial del usuario.
* **`procesarEstudiantes`**: Gestiona el bucle de captura de nombres y promedios.
* **`validarNota`**: Un submódulo encargado exclusivamente de asegurar que las calificaciones estén en el rango correcto.
* **`mostrarResultados`**: Separa la capa de presentación de la lógica de negocio.

## 3. Justificación de Variables Locales y Globales
* **Variables Locales:** Se utilizaron en su totalidad dentro de cada método. Esto garantiza la **encapsulación**, evita que una función modifique accidentalmente datos de otra y optimiza el uso de memoria (ya que la variable se destruye al terminar la función).
* **Variables Globales:** Se evitaron para prevenir "efectos secundarios" y mantener el código fácil de testear.

## 4. Respuestas a Preguntas Guía
* **¿Por qué modularizar?** Porque permite reutilizar código y facilita la detección de errores de forma aislada.
* **¿Qué impacto tiene el manejo de excepciones?** Evita que el programa "muera" ante entradas inválidas, ofreciendo una experiencia de usuario robusta.

## 5. Explicación de Validaciones Implementadas
Se implementó un sistema de control de errores mediante:
1.  **Bloques `try-catch`**: Para capturar el error `InputMismatchException` si el usuario ingresa letras en lugar de números.
2.  **Validación de Rango**: Un ciclo `while` que impide avanzar si la nota no está entre 0 y 10.
3.  **Limpieza de Buffer**: Uso de `scanner.nextLine()` para resetear la entrada tras un error.
