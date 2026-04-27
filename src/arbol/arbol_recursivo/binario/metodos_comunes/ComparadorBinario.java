package arbol.arbol_recursivo.binario.metodos_comunes;

public class ComparadorBinario {

    public static <T extends Comparable<T>> int comparar(T a, T b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }
}