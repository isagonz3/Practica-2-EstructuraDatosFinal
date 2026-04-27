package arbol.arbol_recursivo.interfaces;

import estructuras_necesarias.MyList;

public interface Arbol<T extends Comparable<T>> {

    // Operaciones básicas
    void add(T data);                  // insertar en el árbol
    boolean isEmpty();

    // Propiedades estructurales
    int getGrado();                    // grado máximo del árbol
    int getAltura();                   // altura del árbol

    // Listas por nivel y camino
    MyList<T> getListaDatosNivel(int nivel);
    MyList<T> getCamino(T data);       // camino desde la raíz hasta el dato

    // Tipos de árbol
    boolean isArbolHomogeneo();
    boolean isArbolCompleto();
    boolean isArbolCasiCompleto();

    // Recorridos
    MyList<T> getListaPreOrden();
    MyList<T> getListaPostOrden();
    MyList<T> getListaOrdenCentral();
}
