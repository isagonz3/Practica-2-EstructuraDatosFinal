package arbol.arbol_recursivo.interfaces;

import estructuras_necesarias.MyList;

public interface Arbol<T extends Comparable<T>> {

    void add(T data);
    boolean isEmpty();

    int getGrado();
    int getAltura();

    MyList<T> getListaDatosNivel(int nivel);
    MyList<T> getCamino(T data);

    boolean isArbolHomogeneo();
    boolean isArbolCompleto();
    boolean isArbolCasiCompleto();

    MyList<T> getListaPreOrden();
    MyList<T> getListaPostOrden();
    MyList<T> getListaOrdenCentral();
}
