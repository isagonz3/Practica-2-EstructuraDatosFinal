package Descartadas.Carolina.arboles.arbol_recursivo.binario.metodos_comunes;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public class Profundidad<T extends Comparable<T>> { //clase para calcular la profundidad de un nodo

    public int calcularProfundidad(NodoBinario<T> raiz, T data) { //devuelve nivel de un nodo
        return profundidadRec(raiz, data, 0); //empieza desde nivel 0
    }

    private int profundidadRec(NodoBinario<T> nodo, T data, int nivel) { //recursión de búsqueda

        if (nodo == null) return -1; //si no existe el nodo

        int cmp = data.compareTo(nodo.getData()); //comparación con el nodo actual

        if (cmp == 0) return nivel; //si se encuentra, devuelve nivel

        if (cmp < 0) { //si es menor, va izquierda
            return profundidadRec(nodo.getLeft(), data, nivel + 1);
        }

        return profundidadRec(nodo.getRight(), data, nivel + 1); //si es mayor, derecha
    }
}