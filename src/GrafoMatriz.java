/** Grafo no dirigido y ponderado con matriz de adyacencia (0 = sin arista). */
public class GrafoMatriz {
    private final String[] etiquetas;
    private final int[][] m;

    public GrafoMatriz(String... etiquetas) {
        this.etiquetas = etiquetas;
        this.m = new int[etiquetas.length][etiquetas.length];
    }

    public void agregarArista(int u, int v, int peso) {
        m[u][v] = peso;
        m[v][u] = peso;
    }

    public int peso(int u, int v) { return m[u][v]; }

    public void imprimir() {
        StringBuilder sb = new StringBuilder("   ");
        for (String e : etiquetas) sb.append(String.format("%3s", e));
        System.out.println(sb);
        for (int i = 0; i < m.length; i++) {
            sb = new StringBuilder(String.format("%-3s", etiquetas[i]));
            for (int j = 0; j < m.length; j++) sb.append(String.format("%3d", m[i][j]));
            System.out.println(sb);
        }
    }
}
