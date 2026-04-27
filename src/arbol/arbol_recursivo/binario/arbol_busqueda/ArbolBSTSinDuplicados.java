package arbol.arbol_recursivo.binario.arbol_busqueda;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBSTSinDuplicados<T extends Comparable<T>> extends ArbolBSTBase<T> {

    @Override
    public void insertar(T data) {
        root = insertarRec(root, data);
    }

    private NodoBinario<T> insertarRec(NodoBinario<T> nodo, T data) {
        if (nodo == null) return new NodoBinario<>(data);
        int cmp = data.compareTo(nodo.getData());
        if (cmp < 0) {
            nodo.setLeft(insertarRec(nodo.getLeft(), data));
        } else if (cmp > 0) {
            nodo.setRight(insertarRec(nodo.getRight(), data));
        } // si es igual, se ignora (sin duplicados)
        return nodo;
    }

    @Override
    public NodoBinario<T> buscar(T data) {
        return buscarRec(root, data);
    }

    private NodoBinario<T> buscarRec(NodoBinario<T> nodo, T data) {
        if (nodo == null) return null;
        int cmp = data.compareTo(nodo.getData());
        if (cmp == 0) return nodo;
        if (cmp < 0) return buscarRec(nodo.getLeft(), data);
        return buscarRec(nodo.getRight(), data);
    }

    @Override
    public void eliminar(T data) {
        root = eliminarRec(root, data);
    }

    private NodoBinario<T> eliminarRec(NodoBinario<T> nodo, T data) {
        if (nodo == null) return null;
        int cmp = data.compareTo(nodo.getData());
        if (cmp < 0) {
            nodo.setLeft(eliminarRec(nodo.getLeft(), data));
        } else if (cmp > 0) {
            nodo.setRight(eliminarRec(nodo.getRight(), data));
        } else {
            // nodo encontrado
            if (nodo.getLeft() == null) return nodo.getRight();
            if (nodo.getRight() == null) return nodo.getLeft();
            // dos hijos: usar sucesor (mínimo del subárbol derecho)
            NodoBinario<T> sucesor = min(nodo.getRight());
            nodo.setData(sucesor.getData());
            nodo.setRight(eliminarRec(nodo.getRight(), sucesor.getData()));
        }
        return nodo;
    }

    private NodoBinario<T> min(NodoBinario<T> nodo) {
        while (nodo.getLeft() != null) nodo = nodo.getLeft();
        return nodo;
    }
}