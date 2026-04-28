package arbol.arbol_recursivo.binario;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBinario<T extends Comparable<T>> extends ArbolBinarioBase<T> {

    @Override
    public void add(T data) {
        root = insertarRec(root, data);
    }

    private NodoBinario<T> insertarRec(NodoBinario<T> nodo, T data) {
        if (nodo == null) return new NodoBinario<>(data);
        if (nodo.getLeft() == null) {
            nodo.setLeft(new NodoBinario<>(data));
        } else if (nodo.getRight() == null) {
            nodo.setRight(new NodoBinario<>(data));
        } else {
            nodo.setLeft(insertarRec(nodo.getLeft(), data));
        }
        return nodo;
    }
}
