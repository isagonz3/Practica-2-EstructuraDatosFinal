package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBSTConDuplicados<T extends Comparable<T>> extends ArbolBSTBase<T> { //árbol binario de búsqueda que sí permite duplicados

    @Override
    public void insertar(T data) { //inserta un dato en el árbol
        raiz = insertarRec(raiz, data); //llama al metodo recursivo desde la raíz
    }

    private NodoBinario<T> insertarRec(NodoBinario<T> nodo, T data) { //inserción en bst permitiendo duplicados
        if (nodo == null) return new NodoBinario<>(data); //si se llega a un hueco se crea el nodo

        int cmp = data.compareTo(nodo.getData()); //compara el dato con el nodo actual

        if (cmp < 0) { //si es menor va al subárbol izquierdo
            nodo.setLeft(insertarRec(nodo.getLeft(), data));
        } else { //si es mayor o igual va al subárbol derecho (aquí se meten los duplicados)
            nodo.setRight(insertarRec(nodo.getRight(), data));
        }

        return nodo; //devuelve el nodo actual para mantener la estructura
    }

    @Override
    public NodoBinario<T> buscar(T data) { //busca un dato en el árbol
        return buscarRec(raiz, data); //empieza desde la raíz
    }

    private NodoBinario<T> buscarRec(NodoBinario<T> nodo, T data) { //búsqueda en bst
        if (nodo == null) return null; //si no se encuentra devuelve null

        int cmp = data.compareTo(nodo.getData()); //compara el dato buscado con el nodo actual

        if (cmp == 0) return nodo; //si coincide devuelve el nodo
        if (cmp < 0) return buscarRec(nodo.getLeft(), data); //si es menor busca en la izquierda

        return buscarRec(nodo.getRight(), data); //si es mayor busca en la derecha
    }

    @Override
    public void eliminar(T data) { //elimina un nodo del árbol
        raiz = eliminarRec(raiz, data); //llama al metodo recursivo desde la raíz
    }

    private NodoBinario<T> eliminarRec(NodoBinario<T> nodo, T data) { //eliminación en bst
        if (nodo == null) return null; //si no existe el nodo no se hace nada

        int cmp = data.compareTo(nodo.getData()); //compara el dato con el nodo actual

        if (cmp < 0) { //si es menor se busca en la izquierda
            nodo.setLeft(eliminarRec(nodo.getLeft(), data));
        } else if (cmp > 0) { //si es mayor se busca en la derecha
            nodo.setRight(eliminarRec(nodo.getRight(), data));
        } else { //si se encuentra el nodo a eliminar

            if (nodo.getLeft() == null) return nodo.getRight(); //si solo tiene hijo derecho o ninguno
            if (nodo.getRight() == null) return nodo.getLeft(); //si solo tiene hijo izquierdo

            //si tiene dos hijos se busca el sucesor (mínimo del subárbol derecho)
            NodoBinario<T> sucesor = min(nodo.getRight());

            nodo.setData(sucesor.getData()); //se reemplaza el valor por el del sucesor

            nodo.setRight(eliminarRec(nodo.getRight(), sucesor.getData())); //se elimina el sucesor duplicado
        }

        return nodo; //devuelve el nodo actualizado
    }

    private NodoBinario<T> min(NodoBinario<T> nodo) { //busca el nodo con menor valor
        while (nodo.getLeft() != null) nodo = nodo.getLeft(); //se baja siempre por la izquierda
        return nodo; //devuelve el mínimo
    }
}