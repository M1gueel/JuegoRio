<h1 align="center">
    Escuela Politécnica Nacional<br>
    Facultad de Ingeniería en Sistemas<br>
    Metodologías Ágiles<br>
</h1>

### Integrantes - Grupo 3

Guilca Miguel  
Joel Guingla  
Stefano Landázuri  
Juan Pablo Obregon  
Cristofer Paucar  
Kenny Pinchao

# Documento de Prácticas de Codificación

## Convenciones y Prácticas Recomendadas

### Nomenclatura de Variables:

1. **Jugadores:**
   - Se utilizará nombres descriptivos para las variables que representan a los jugadores.
   - Ejemplo: `PlayerObservador`, `PlayerLobo`, `PlayerCaperucita`, `PlayerUvas`.

2. **Canoa:**
   - Se utilizará un nombre claro y conciso para la variable que representa la canoa.
   - Ejemplo: `canoa`.

3. **Estados del Juego:**
   - Si es necesario se utilizará variables para representar estados del juego, usa nombres explicativos.
   - Ejemplo: `estadoDelJuego`, `jugadoresEnElBarco`, etc.

### Comentarios:

1. **Comentarios Explicativos:**
   - Se incluirá comentarios explicativos cuando sea necesario para aclarar el propósito de una sección de código.
   - Ejemplo: `// Mover jugadores al otro lado del río`.

2. **Comentarios de Autoría:**
   - Se incluirá comentarios de autoría para indicar quién escribió una parte específica del código, especialmente en colaboraciones.
   - Ejemplo: `// Autor: [Tu Nombre]`.

### Estructura del Código:

1. **Modularización:**
   - Se dividirá el código en funciones o clases para mejorar la legibilidad y la mantenibilidad.
   - Ejemplo: Separa la lógica del menú principal, la lógica del juego, etc.

2. **Organización de Importaciones:**
   - Se organizará las importaciones de manera lógica y agrúpalas según su origen (paquetes del sistema, bibliotecas externas, tus propios módulos).
   - Ejemplo:
     ```java
     import java.util.*;
     import mi.paquete.clases.*;
     ```

### Prácticas de Nomenclatura:

1. **Variables Descriptivas:**
   - Se eligirá nombres de variables que describan claramente su propósito y contenido.
   - Ejemplo: `observadorEnBarco`, `posicionInicialCaperucita`.

2. **Constantes en Mayúsculas:**
   - Se usará mayúsculas para nombrar constantes y separa palabras con guiones bajos.
   - Ejemplo: `LIMITE_CANOA`, `RESTRICCION_LOBO_CAPERUCITA`.

### Control de Versiones:

1. **Comentarios de Confirmación:**
   - Se incluirá comentarios claros al confirmar cambios para explicar el propósito de la confirmación.
   - Ejemplo: `git commit -m "Agrega lógica de movimiento de jugadores"`.

2. **Ramas Explícitas:**
   - Se utilizará ramas con nombres descriptivos para nuevos desarrollos o correcciones.
   - Ejemplo: `feature/nueva-logica-juego`, `bugfix/corregir-validaciones`.
