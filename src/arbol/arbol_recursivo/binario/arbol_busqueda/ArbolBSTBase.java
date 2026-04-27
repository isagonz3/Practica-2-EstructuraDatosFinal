package arbol.arbol_recursivo.binario.arbol_busqueda;

import arbol.arbol_recursivo.binario.ArbolBinarioBase;
import arbol.arbol_recursivo.binario.nodo.NodoBinario;

public abstract class ArbolBSTBase<T extends Comparable<T>> extends ArbolBinarioBase<T> {

    public abstract void insertar(T data);
    public abstract NodoBinario<T> buscar(T data);
    public abstract void eliminar(T data);

    @Override
    public void add(T data) {
        insertar(data);
    }
}
