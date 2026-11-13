import java.util.List;

/** Demostracion sobre un grafo base de 6 vertices y verificacion de resultados esperados. */
public class Main {
    public static void main(String[] args) {
        String[] nombres = {"A", "B", "C", "D", "E", "F"};
        int[][] aristas = {{0, 1, 4}, {0, 2, 2}, {1, 3, 5}, {2, 3, 1}, {2, 4, 10}, {3, 5, 6}, {4, 5, 3}};

        GrafoLista lista = new GrafoLista(nombres);
        GrafoMatriz matriz = new GrafoMatriz(nombres);
        for (int[] a : aristas) {
            lista.agregarArista(a[0], a[1], a[2]);
            matriz.agregarArista(a[0], a[1], a[2]);
        }

        System.out.println("== Lista de adyacencia ==");
        lista.imprimir();
        System.out.println("\n== Matriz de adyacencia ==");
        matriz.imprimir();

        String bfs = nombres(lista, Recorridos.bfs(lista, 0));
        String dfs = nombres(lista, Recorridos.dfs(lista, 0));
        System.out.println("\nBFS desde A: " + bfs);
        System.out.println("DFS desde A: " + dfs);

        List<Arista> prim = ArbolExpansionMinima.prim(lista, 0);
        List<Arista> kruskal = ArbolExpansionMinima.kruskal(lista);
        System.out.println("\nPrim desde A:  " + aristas(lista, prim) + " peso=" + ArbolExpansionMinima.pesoTotal(prim));
        System.out.println("Kruskal:       " + aristas(lista, kruskal) + " peso=" + ArbolExpansionMinima.pesoTotal(kruskal));

        verificar(bfs.equals("A B C D E F"), "BFS");
        verificar(dfs.equals("A B D C E F"), "DFS");
        verificar(ArbolExpansionMinima.pesoTotal(prim) == 16, "Prim");
        verificar(ArbolExpansionMinima.pesoTotal(kruskal) == 16, "Kruskal");
        System.out.println("\nTodas las verificaciones pasaron.");
    }

    private static String nombres(GrafoLista g, List<Integer> orden) {
        StringBuilder sb = new StringBuilder();
        for (int v : orden) sb.append(g.etiqueta(v)).append(' ');
        return sb.toString().trim();
    }

    private static String aristas(GrafoLista g, List<Arista> l) {
        StringBuilder sb = new StringBuilder();
        for (Arista a : l) sb.append(g.etiqueta(a.u())).append('-').append(g.etiqueta(a.v())).append('(').append(a.peso()).append(") ");
        return sb.toString().trim();
    }

    private static void verificar(boolean ok, String que) {
        if (!ok) throw new AssertionError("Fallo: " + que);
    }
}
