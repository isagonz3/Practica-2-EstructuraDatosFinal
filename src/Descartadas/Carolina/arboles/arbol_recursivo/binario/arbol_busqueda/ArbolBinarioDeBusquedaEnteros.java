package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.estructuras_necesarias.MyIterate;
import Descartadas.Carolina.estructuras_necesarias.MyList;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBSTSinDuplicados<Integer> { //árbol bst específico para enteros sin duplicados

    public int getSuma() { //devuelve la suma de todos los valores del árbol
        MyList<Integer> lista = getListaOrdenCentral(); //obtiene los datos en inorden (aunque el orden no afecta a la suma)

        MyIterate<Integer> it = lista.getIterate(); //iterador para recorrer la lista
        int suma = 0; //acumulador de la suma

        while (it.hasNext()) { //mientras haya elementos en la lista
            suma += it.next(); //se van sumando uno a uno
        }

        return suma; //devuelve el resultado final
    }
}