package arbol.arbol_recursivo.binario.arbol_busqueda;

import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBalanceado<T extends Comparable<T>> extends ArbolBSTSinDuplicados<T> {

    @Override
    public void insertar(T data) {
        root = insertarAVL(root, data);
    }

    private NodoBinario<T> insertarAVL(NodoBinario<T> nodo, T data) {
        if (nodo == null) return new NodoBinario<>(data);

        int cmp = data.compareTo(nodo.getData());
        if (cmp < 0) {
            nodo.setLeft(insertarAVL(nodo.getLeft(), data));
        } else if (cmp > 0) {
            nodo.setRight(insertarAVL(nodo.getRight(), data));
        } else {
            return nodo;
        }

        return balancear(nodo);
    }

    @Override
    public void eliminar(T data) {
        root = eliminarAVL(root, data);
    }

    private NodoBinario<T> eliminarAVL(NodoBinario<T> nodo, T data) {
        if (nodo == null) return null;

        int cmp = data.compareTo(nodo.getData());
        if (cmp < 0) {
            nodo.setLeft(eliminarAVL(nodo.getLeft(), data));
        } else if (cmp > 0) {
            nodo.setRight(eliminarAVL(nodo.getRight(), data));
        } else {
            if (nodo.getLeft() == null) return nodo.getRight();
            if (nodo.getRight() == null) return nodo.getLeft();

            NodoBinario<T> sucesor = min(nodo.getRight());
            nodo.setData(sucesor.getData());
            nodo.setRight(eliminarAVL(nodo.getRight(), sucesor.getData()));
        }

        return balancear(nodo);
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


    private int altura(NodoBinario<T> nodo) {
        if (nodo == null) return -1;
        int izq = altura(nodo.getLeft());
        int der = altura(nodo.getRight());
        return 1 + (izq > der ? izq : der);
    }

    private int factorBalance(NodoBinario<T> nodo) {
        if (nodo == null) return 0;
        return altura(nodo.getLeft()) - altura(nodo.getRight());
    }

    private NodoBinario<T> balancear(NodoBinario<T> nodo) {
        int fb = factorBalance(nodo);

        if (fb > 1) {
            if (factorBalance(nodo.getLeft()) < 0) {
                nodo.setLeft(rotacionIzquierda(nodo.getLeft())); // LR
            }
            return rotacionDerecha(nodo); // LL
        }

        if (fb < -1) {
            if (factorBalance(nodo.getRight()) > 0) {
                nodo.setRight(rotacionDerecha(nodo.getRight())); // RL
            }
            return rotacionIzquierda(nodo); // RR
        }

        return nodo;
    }

    private NodoBinario<T> rotacionDerecha(NodoBinario<T> y) {
        NodoBinario<T> x = y.getLeft();
        NodoBinario<T> T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        return x;
    }

    private NodoBinario<T> rotacionIzquierda(NodoBinario<T> x) {
        NodoBinario<T> y = x.getRight();
        NodoBinario<T> T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        return y;
    }

    private NodoBinario<T> min(NodoBinario<T> nodo) {
        while (nodo.getLeft() != null) nodo = nodo.getLeft();
        return nodo;
    }
}