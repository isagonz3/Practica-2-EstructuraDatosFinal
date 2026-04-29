package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.ArbolBinarioBase;
import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public abstract class ArbolBSTBase<T extends Comparable<T>> extends ArbolBinarioBase<T> { //clase base abstracta para árboles binarios de búsqueda

    public abstract void insertar(T data); //metodo abstracto para insertar un dato según la lógica del bst

    public abstract NodoBinario<T> buscar(T data); //metodo abstracto para buscar un nodo con un dato concreto

    public abstract void eliminar(T data); //metodo abstracto para eliminar un dato del árbol

    @Override
    public void add(T data) { //implementación del metodo add heredado del árbol base
        insertar(data); //simplemente delega en el metodo insertar
    }
}