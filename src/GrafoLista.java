import java.util.ArrayList;
import java.util.List;

/** Grafo no dirigido y ponderado con lista de adyacencia. */
public class GrafoLista {
    private final String[] etiquetas;
    private final List<List<int[]>> ady = new ArrayList<>(); // cada par: {vecino, peso}

    public GrafoLista(String... etiquetas) {
        this.etiquetas = etiquetas;
        for (int i = 0; i < etiquetas.length; i++) ady.add(new ArrayList<>());
    }

    public void agregarArista(int u, int v, int peso) {
        ady.get(u).add(new int[]{v, peso});
        ady.get(v).add(new int[]{u, peso});
    }

    public int tamano() { return etiquetas.length; }

    public String etiqueta(int i) { return etiquetas[i]; }

    public List<int[]> vecinos(int u) { return ady.get(u); }

    /** Cada arista aparece una sola vez (u < v). */
    public List<Arista> aristas() {
        List<Arista> lista = new ArrayList<>();
        for (int u = 0; u < tamano(); u++)
            for (int[] p : ady.get(u))
                if (u < p[0]) lista.add(new Arista(u, p[0], p[1]));
        return lista;
    }

    public void imprimir() {
        for (int u = 0; u < tamano(); u++) {
            StringBuilder sb = new StringBuilder(etiquetas[u] + " -> ");
            for (int[] p : ady.get(u)) sb.append(etiquetas[p[0]]).append('(').append(p[1]).append(") ");
            System.out.println(sb.toString().trim());
        }
    }
}
