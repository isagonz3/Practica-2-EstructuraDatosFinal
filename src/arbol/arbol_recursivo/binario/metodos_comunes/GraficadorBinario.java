package arbol.arbol_recursivo.binario.metodos_comunes;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public class GraficadorBinario {

    public static <T extends Comparable<T>> String toString(NodoBinario<T> root) {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb, 0);
        return sb.toString();
    }

    private static <T extends Comparable<T>> void toStringRec(NodoBinario<T> nodo, StringBuilder sb, int nivel) {
        if (nodo == null) return;
        toStringRec(nodo.getRight(), sb, nivel + 1);
        for (int i = 0; i < nivel; i++) sb.append("   ");
        sb.append(nodo.getData()).append("\n");
        toStringRec(nodo.getLeft(), sb, nivel + 1);
    }
}
