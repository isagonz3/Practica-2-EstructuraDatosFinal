package arbol.arbol_recursivo.binario.arbol_busqueda;

import estructuras_necesarias.MyIterate;
import estructuras_necesarias.MyList;

public class ArbolBalanceadoEnteros extends ArbolBalanceado<Integer> {

    public int getSuma() {
        MyList<Integer> lista = getListaOrdenCentral();
        MyIterate<Integer> it = lista.getIterate();

        int suma = 0;
        while (it.hasNext()) {
            suma += it.next();
        }
        return suma;
    }
}
