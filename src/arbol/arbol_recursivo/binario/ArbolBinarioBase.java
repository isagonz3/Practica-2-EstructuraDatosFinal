package arbol.arbol_recursivo.binario;

import arbol.arbol_recursivo.binario.metodos_comunes.GraficadorBinario;
import arbol.arbol_recursivo.binario.metodos_comunes.Recorridos;
import arbol.arbol_recursivo.binario.metodos_comunes.ValidadorBinario;
import arbol.arbol_recursivo.binario.nodo.NodoBinario;
import arbol.arbol_recursivo.interfaces.Arbol;
import estructuras_necesarias.ListSE;
import estructuras_necesarias.MyList;

public abstract class ArbolBinarioBase<T extends Comparable<T>> implements Arbol<T> {

    protected NodoBinario<T> root;

    public ArbolBinarioBase() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getGrado() {
        return grado(root);
    }

    private int grado(NodoBinario<T> nodo) {
        if (nodo == null) return 0;
        int hijos = 0;
        if (nodo.getLeft() != null) hijos++;
        if (nodo.getRight() != null) hijos++;
        return Math.max(hijos, Math.max(grado(nodo.getLeft()), grado(nodo.getRight())));
    }

    @Override
    public int getAltura() {
        return altura(root);
    }

    private int altura(NodoBinario<T> nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.getLeft()), altura(nodo.getRight()));
    }

    @Override
    public MyList<T> getListaDatosNivel(int nivel) {
        MyList<T> lista = new ListSE<>();
        getDatosNivelRec(root, 0, nivel, lista);
        return lista;
    }

    private void getDatosNivelRec(NodoBinario<T> nodo, int actual, int objetivo, MyList<T> lista) {
        if (nodo == null) return;
        if (actual == objetivo) {
            lista.addLast(nodo.getData());
        } else {
            getDatosNivelRec(nodo.getLeft(), actual + 1, objetivo, lista);
            getDatosNivelRec(nodo.getRight(), actual + 1, objetivo, lista);
        }
    }

    @Override
    public boolean isArbolHomogeneo() {
        return ValidadorBinario.esHomogeneo(root);
    }

    @Override
    public boolean isArbolCompleto() {
        return ValidadorBinario.esCompleto(root);
    }

    @Override
    public boolean isArbolCasiCompleto() {
        return ValidadorBinario.esCasiCompleto(root);
    }

    @Override
    public MyList<T> getCamino(T data) {
        ListSE<T> camino = new ListSE<>();
        if (buscarCamino(root, data, camino)) {
            return camino;
        }
        return new ListSE<>();
    }

    private boolean buscarCamino(NodoBinario<T> nodo, T data, ListSE<T> camino) {
        if (nodo == null) return false;
        camino.addLast(nodo.getData());
        int cmp = data.compareTo(nodo.getData());
        if (cmp == 0) return true;
        if (cmp < 0) {
            if (buscarCamino(nodo.getLeft(), data, camino)) return true;
        } else {
            if (buscarCamino(nodo.getRight(), data, camino)) return true;
        }
        camino.del(nodo.getData());
        return false;
    }

    @Override
    public MyList<T> getListaPreOrden() {
        return Recorridos.preOrden(root);
    }

    @Override
    public MyList<T> getListaPostOrden() {
        return Recorridos.postOrden(root);
    }

    @Override
    public MyList<T> getListaOrdenCentral() {
        return Recorridos.inOrden(root);
    }

    @Override
    public String toString() {
        return GraficadorBinario.toString(root);
    }
}