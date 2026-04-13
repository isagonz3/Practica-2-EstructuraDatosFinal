package practica_2.arbol.arbol_iterativo;

public class ArbolBusquedaBinariaEnteros extends ArbolBusquedaBinaria<Integer> {

    public ArbolBusquedaBinariaEnteros() {
        super();
    }

    public int getSuma() {
        return sumarRec(raiz);
    }

    private int sumarRec(NodoArbol<Integer> nodo) {
        if (nodo == null) return 0;

        int sumaIzq = sumarRec(nodo.hijoIzquierdo);
        int sumaDer = sumarRec(nodo.hijoDerecho);

        return nodo.dato + sumaIzq + sumaDer;
    }
}