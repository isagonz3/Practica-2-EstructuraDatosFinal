package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBSTSinDuplicados<Integer> { //árbol BST sin duplicados especializado en enteros

    public int calcularSumaElementos() { //calcula la suma de todos los elementos del árbol
        return sumarRec(raiz); //CAMBIO: recorrido directo sin lista intermedia
    }

    private int sumarRec(NodoBinario<Integer> nodo) { //recorrido recursivo del árbol

        if (nodo == null) return 0; //caso base: si no hay nodo, suma 0

        return nodo.getData() //valor del nodo actual
                + sumarRec(nodo.getLeft()) //suma del subárbol izquierdo
                + sumarRec(nodo.getRight()); //suma del subárbol derecho
    }
}