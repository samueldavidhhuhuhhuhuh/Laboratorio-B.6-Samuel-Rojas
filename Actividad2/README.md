# Sistema de Votación Electrónica

Este programa simula un sistema de votación electrónica que permite registrar votos, evitar votos duplicados y realizar un escrutinio de votos por candidato.

## Cómo Funciona

1. Cada voto tiene un candidato y un identificador único (`id`).
2. Los votos se almacenan en un `HashMap` para garantizar que no haya duplicados.
3. El escrutinio se actualiza automáticamente cada vez que se registra un voto válido.
4. El sistema permite agregar votos y mostrar el escrutinio actual.

## Estructuras de Datos Utilizadas

- **HashMap**: Para almacenar votos únicos (usando el `id` como clave).
- **HashMap**: Para almacenar el conteo de votos por candidato.

## Descripción de las Clases

### 1. **Voto**
   - Representa un voto con un candidato y un identificador único (`id`).
   - Métodos: `getCandidato()`, `getId()`, `equals()`, `hashCode()`.

### 2. **SistemaVotacion**
   - Gestiona los votos y el escrutinio.
   - Métodos: `agregarVoto()`, `mostrarEscrutinio()`.

### 3. **Main**
   - Punto de entrada del programa.
   - Implementa un menú interactivo para agregar votos y mostrar el escrutinio.

---

## Ejemplo de Uso

### Menú Principal
El programa muestra un menú con las siguientes opciones:

1. **Agregar voto**:
   - Solicita el nombre del candidato y el ID del voto.
   - Ejemplo:
     ```
     Nombre del candidato: Candidato A
     ID del voto: 1
     ```

2. **Mostrar escrutinio**:
   - Muestra el conteo de votos por candidato.
   - Ejemplo:
     ```
     Escrutinio:
     Candidato A: 5 votos
     Candidato B: 3 votos
     Candidato C: 2 votos
     ```

3. **Salir**:
   - Termina la ejecución del programa.

---

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- Una IDE o editor de texto para Java (opcional, pero recomendado).

---

## Cómo Ejecutar el Proyecto

1. Clona o descarga el repositorio.
2. Abre una terminal en la carpeta del proyecto.
3. Compila el código:
   java SistemaVotacion.java
# Diagrama de Clases
![Diagrama de Clases](./diagrama_clases.png) 
