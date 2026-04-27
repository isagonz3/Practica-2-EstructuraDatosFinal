package arbol.arbol_recursivo.binario.metodos_comunes;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;
import estructuras_necesarias.ListSE;
import estructuras_necesarias.MyList;

public class Recorridos {

    public static <T extends Comparable<T>> MyList<T> preOrden(NodoBinario<T> root) {
        MyList<T> lista = new ListSE<>();
        preOrdenRec(root, lista);
        return lista;
    }

    private static <T extends Comparable<T>> void preOrdenRec(NodoBinario<T> nodo, MyList<T> lista) {
        if (nodo == null) return;
        lista.addLast(nodo.getData());
        preOrdenRec(nodo.getLeft(), lista);
        preOrdenRec(nodo.getRight(), lista);
    }

    public static <T extends Comparable<T>> MyList<T> inOrden(NodoBinario<T> root) {
        MyList<T> lista = new ListSE<>();
        inOrdenRec(root, lista);
        return lista;
    }

    private static <T extends Comparable<T>> void inOrdenRec(NodoBinario<T> nodo, MyList<T> lista) {
        if (nodo == null) return;
        inOrdenRec(nodo.getLeft(), lista);
        lista.addLast(nodo.getData());
        inOrdenRec(nodo.getRight(), lista);
    }

    public static <T extends Comparable<T>> MyList<T> postOrden(NodoBinario<T> root) {
        MyList<T> lista = new ListSE<>();
        postOrdenRec(root, lista);
        return lista;
    }

    private static <T extends Comparable<T>> void postOrdenRec(NodoBinario<T> nodo, MyList<T> lista) {
        if (nodo == null) return;
        postOrdenRec(nodo.getLeft(), lista);
        postOrdenRec(nodo.getRight(), lista);
        lista.addLast(nodo.getData());
    }
}