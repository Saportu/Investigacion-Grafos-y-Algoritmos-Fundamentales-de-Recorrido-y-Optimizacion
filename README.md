# Investigación: Grafos y Algoritmos Fundamentales de Recorrido y Optimización

Instituto Tecnológico de Costa Rica · Escuela de Ingeniería en Computadores
Algoritmos y Estructuras de Datos I · II Semestre 2026
Autor: Santiago Portuguez Hernández

## Descripción de la investigación

Los grafos modelan relaciones entre entidades (ciudades, personas, computadoras) y son la base de redes sociales, sistemas GPS, enrutamiento y muchas aplicaciones de inteligencia artificial. Esta investigación estudia:

1. **Definición de grafos:** teoría (G = (V, E)), terminología, tipos, casos de uso y un grafo de ejemplo.
2. **Representación:** lista y matriz de adyacencia, con ventajas, desventajas y diagramas sobre el mismo grafo base.
3. **Recorridos:** búsqueda en anchura (BFS) y en profundidad (DFS), con su complejidad.
4. **Árbol de expansión mínima:** algoritmos de Prim y Kruskal, con su complejidad.

Todos los temas se ilustran sobre un mismo grafo ponderado de 6 vértices (A–F) y 7 aristas. Los algoritmos están implementados en Java y el programa `Main` verifica automáticamente los resultados esperados.

## Estructura

| Archivo | Contenido |
|---|---|
| `src/GrafoLista.java` | Grafo con lista de adyacencia |
| `src/GrafoMatriz.java` | Grafo con matriz de adyacencia |
| `src/Arista.java` | Arista ponderada (`record`) |
| `src/Recorridos.java` | BFS y DFS |
| `src/ArbolExpansionMinima.java` | Prim, Kruskal (Union-Find) |
| `src/Main.java` | Demostración y verificación |

## Complejidad

| Algoritmo | Tiempo | Nota |
|---|---|---|
| BFS / DFS | O(V + E) | Con lista de adyacencia; O(V²) con matriz |
| Prim | O(E log V) | Con cola de prioridad |
| Kruskal | O(E log V) | Ordenamiento + Union-Find |

## Ejecución

Requiere JDK 17 o superior (se usa `record`).

```bash
cd src
javac -d ../out *.java
java -cp ../out Main
```

Salida esperada (resumen):

```
BFS desde A: A B C D E F
DFS desde A: A B D C E F
Prim desde A:  A-C(2) C-D(1) A-B(4) D-F(6) F-E(3) peso=16
Kruskal:       C-D(1) A-C(2) E-F(3) A-B(4) D-F(6) peso=16
Todas las verificaciones pasaron.
```
