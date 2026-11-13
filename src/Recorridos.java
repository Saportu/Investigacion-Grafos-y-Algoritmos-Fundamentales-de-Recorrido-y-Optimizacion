import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Recorridos BFS y DFS. Complejidad: O(V + E) con lista de adyacencia. */
public class Recorridos {

    /** Recorrido por anchura: visita por niveles usando una cola. */
    public static List<Integer> bfs(GrafoLista g, int inicio) {
        List<Integer> orden = new ArrayList<>();
        boolean[] visitado = new boolean[g.tamano()];
        Queue<Integer> cola = new ArrayDeque<>();
        visitado[inicio] = true;
        cola.add(inicio);
        while (!cola.isEmpty()) {
            int u = cola.remove();
            orden.add(u);
            for (int[] p : g.vecinos(u)) {
                if (!visitado[p[0]]) {
                    visitado[p[0]] = true; // se marca al encolar para no repetir
                    cola.add(p[0]);
                }
            }
        }
        return orden;
    }

    /** Recorrido por profundidad: avanza lo mas posible y retrocede (recursivo). */
    public static List<Integer> dfs(GrafoLista g, int inicio) {
        List<Integer> orden = new ArrayList<>();
        dfs(g, inicio, new boolean[g.tamano()], orden);
        return orden;
    }

    private static void dfs(GrafoLista g, int u, boolean[] visitado, List<Integer> orden) {
        visitado[u] = true;
        orden.add(u);
        for (int[] p : g.vecinos(u))
            if (!visitado[p[0]]) dfs(g, p[0], visitado, orden);
    }
}
