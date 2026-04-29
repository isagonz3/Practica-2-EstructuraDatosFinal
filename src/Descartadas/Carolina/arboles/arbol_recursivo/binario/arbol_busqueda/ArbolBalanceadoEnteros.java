package Descartadas.Carolina.arboles.arbol_recursivo.binario.arbol_busqueda;

import Descartadas.Carolina.estructuras_necesarias.MyIterate;
import Descartadas.Carolina.estructuras_necesarias.MyList;

public class ArbolBalanceadoEnteros extends ArbolBalanceado<Integer> { //árbol balanceado especializado en enteros

    public int getSuma() { //devuelve la suma de todos los elementos del árbol
        MyList<Integer> lista = getListaOrdenCentral(); //recorre el árbol en inorden y guarda los datos en una lista

        MyIterate<Integer> it = lista.getIterate(); //iterador para recorrer la lista de forma secuencial

        int suma = 0; //acumulador de la suma

        while (it.hasNext()) { //mientras queden elementos en la lista
            suma += it.next(); //se van sumando uno a uno
        }

        return suma; //devuelve la suma total
    }
}