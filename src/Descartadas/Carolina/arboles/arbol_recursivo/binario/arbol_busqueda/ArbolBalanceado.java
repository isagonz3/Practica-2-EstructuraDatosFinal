package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.arboles.arbol_recursivo.binario.nodo.NodoBinario;

public class ArbolBalanceado<T extends Comparable<T>> extends ArbolBSTSinDuplicados<T> { //árbol bst balanceado tipo avl

    @Override
    public void insertar(T data) { //inserta un dato manteniendo el equilibrio del árbol
        raiz = insertarAVL(raiz, data); //llama al metodo recursivo desde la raíz
    }

    private NodoBinario<T> insertarAVL(NodoBinario<T> nodo, T data) { //inserción con balanceo avl
        if (nodo == null) return new NodoBinario<>(data); //si hay hueco se inserta el nodo

        int cmp = data.compareTo(nodo.getData()); //compara el dato con el nodo actual

        if (cmp < 0) { //si es menor va a la izquierda
            nodo.setLeft(insertarAVL(nodo.getLeft(), data));
        } else if (cmp > 0) { //si es mayor va a la derecha
            nodo.setRight(insertarAVL(nodo.getRight(), data));
        } else {
            return nodo; //si es igual no se inserta (no duplicados)
        }

        return balancear(nodo); //al volver se reequilibra el nodo
    }

    @Override
    public void eliminar(T data) { //elimina un nodo manteniendo el balance
        raiz = eliminarAVL(raiz, data); //llama al metodo recursivo
    }

    private NodoBinario<T> eliminarAVL(NodoBinario<T> nodo, T data) { //eliminación con rebalanceo
        if (nodo == null) return null; //si no existe no hace nada

        int cmp = data.compareTo(nodo.getData()); //compara el dato

        if (cmp < 0) { //si es menor se busca en la izquierda
            nodo.setLeft(eliminarAVL(nodo.getLeft(), data));
        } else if (cmp > 0) { //si es mayor se busca en la derecha
            nodo.setRight(eliminarAVL(nodo.getRight(), data));
        } else { //si se encuentra el nodo

            if (nodo.getLeft() == null) return nodo.getRight(); //caso 1 hijo derecho o ninguno
            if (nodo.getRight() == null) return nodo.getLeft(); //caso 1 hijo izquierdo

            //caso 2 hijos: se busca el sucesor
            NodoBinario<T> sucesor = min(nodo.getRight());

            nodo.setData(sucesor.getData()); //se sustituye el valor

            nodo.setRight(eliminarAVL(nodo.getRight(), sucesor.getData())); //se elimina el duplicado
        }

        return balancear(nodo); //se reequilibra después de eliminar
    }

    @Override
    public NodoBinario<T> buscar(T data) { //busca un nodo en el árbol
        return buscarRec(raiz, data); //empieza desde la raíz
    }

    private NodoBinario<T> buscarRec(NodoBinario<T> nodo, T data) { //búsqueda normal en bst
        if (nodo == null) return null; //si no existe devuelve null

        int cmp = data.compareTo(nodo.getData()); //compara el dato

        if (cmp == 0) return nodo; //si coincide lo devuelve
        if (cmp < 0) return buscarRec(nodo.getLeft(), data); //si es menor va a la izquierda

        return buscarRec(nodo.getRight(), data); //si es mayor va a la derecha
    }

    private int altura(NodoBinario<T> nodo) { //calcula la altura del nodo
        if (nodo == null) return -1; //si es nulo devuelve -1

        int izq = altura(nodo.getLeft()); //altura izquierda
        int der = altura(nodo.getRight()); //altura derecha

        return 1 + (izq > der ? izq : der); //altura máxima + 1
    }

    private int factorBalance(NodoBinario<T> nodo) { //factor de balance
        if (nodo == null) return 0;

        int izq = altura(nodo.getLeft());
        int der = altura(nodo.getRight());

        return izq - der;
    }

    private NodoBinario<T> balancear(NodoBinario<T> nodo) { //equilibra el nodo si está descompensado
        int fb = factorBalance(nodo); //factor de balance

        if (fb > 1) { //caso izquierdo pesado
            if (factorBalance(nodo.getLeft()) < 0) { //caso izquierda-derecha
                nodo.setLeft(rotacionIzquierda(nodo.getLeft()));
            }
            return rotacionDerecha(nodo); //rotación simple derecha
        }

        if (fb < -1) { //caso derecho pesado
            if (factorBalance(nodo.getRight()) > 0) { //caso derecha-izquierda
                nodo.setRight(rotacionDerecha(nodo.getRight()));
            }
            return rotacionIzquierda(nodo); //rotación simple izquierda
        }

        return nodo; //si está equilibrado no se hace nada
    }

    private NodoBinario<T> rotacionDerecha(NodoBinario<T> y) { //rotación simple a la derecha
        NodoBinario<T> x = y.getLeft(); //nuevo raíz
        NodoBinario<T> T2 = x.getRight(); //subárbol intermedio

        x.setRight(y); //recoloca y
        y.setLeft(T2); //reconecta subárbol

        return x; //devuelve nueva raíz
    }

    private NodoBinario<T> rotacionIzquierda(NodoBinario<T> x) { //rotación simple a la izquierda
        NodoBinario<T> y = x.getRight(); //nuevo raíz
        NodoBinario<T> T2 = y.getLeft(); //subárbol intermedio

        y.setLeft(x); //recoloca x
        x.setRight(T2); //reconecta subárbol

        return y; //devuelve nueva raíz
    }

    private NodoBinario<T> min(NodoBinario<T> nodo) { //busca el mínimo del subárbol
        while (nodo.getLeft() != null) nodo = nodo.getLeft(); //baja siempre por la izquierda
        return nodo; //devuelve el nodo mínimo
    }
}