import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Arbol de expansion minima.
 * Prim: O(E log V) con cola de prioridad. Kruskal: O(E log E) por el ordenamiento.
 * Se asume un grafo conexo.
 */
public class ArbolExpansionMinima {

    /** Prim: crece un solo arbol desde 'inicio' tomando siempre la arista mas barata que sale de el. */
    public static List<Arista> prim(GrafoLista g, int inicio) {
        List<Arista> mst = new ArrayList<>();
        boolean[] enArbol = new boolean[g.tamano()];
        PriorityQueue<Arista> cola = new PriorityQueue<>(Comparator.comparingInt(Arista::peso));
        enArbol[inicio] = true;
        for (int[] p : g.vecinos(inicio)) cola.add(new Arista(inicio, p[0], p[1]));
        while (!cola.isEmpty() && mst.size() < g.tamano() - 1) {
            Arista a = cola.remove();
            if (enArbol[a.v()]) continue; // formaria un ciclo
            enArbol[a.v()] = true;
            mst.add(a);
            for (int[] p : g.vecinos(a.v()))
                if (!enArbol[p[0]]) cola.add(new Arista(a.v(), p[0], p[1]));
        }
        return mst;
    }

    /** Kruskal: ordena las aristas y agrega las que no forman ciclo (Union-Find). */
    public static List<Arista> kruskal(GrafoLista g) {
        List<Arista> todas = g.aristas();
        todas.sort(Comparator.comparingInt(Arista::peso));
        int[] padre = new int[g.tamano()];
        for (int i = 0; i < padre.length; i++) padre[i] = i;
        List<Arista> mst = new ArrayList<>();
        for (Arista a : todas) {
            int ru = raiz(padre, a.u()), rv = raiz(padre, a.v());
            if (ru != rv) { // componentes distintas: no hay ciclo
                padre[ru] = rv;
                mst.add(a);
            }
        }
        return mst;
    }

    private static int raiz(int[] padre, int x) {
        while (padre[x] != x) {
            padre[x] = padre[padre[x]]; // compresion de caminos
            x = padre[x];
        }
        return x;
    }

    public static int pesoTotal(List<Arista> mst) {
        return mst.stream().mapToInt(Arista::peso).sum();
    }
}
