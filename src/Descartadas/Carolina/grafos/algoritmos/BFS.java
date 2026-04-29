package Descartadas.Carolina.grafos.algoritmos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.estructuras_necesarias.MyIterate;
import Descartadas.Carolina.estructuras_necesarias.Queue;
import Descartadas.Carolina.grafos.componentes_grafos.GrafoBase;

public class BFS {

    public static ListSE<String> caminoMinimo(GrafoBase grafo, String origen, String destino) {

        Queue<String> cola = new Queue<>();
        ListSE<String> visitado = new ListSE<>();
        ListSE<String> padre = new ListSE<>();

        cola.enqueue(origen);
        visitado.addLast(origen);
        padre.addLast(null);

        while (!cola.isEmpty()) {
            String actual = cola.dequeue();

            if (actual.equals(destino)) break;

            ListSE<String> vecinos = grafo.getVecinos(actual);
            MyIterate<String> it = vecinos.getIterate();

            while (it.hasNext()) {
                String v = it.next();

                if (!visitado.contains(v)) {
                    visitado.addLast(v);
                    padre.addLast(actual);
                    cola.enqueue(v);
                }
            }
        }

        ListSE<String> camino = new ListSE<>();

        if (!visitado.contains(destino)) return camino;

        String nodo = destino;

        while (nodo != null) {
            camino.addLast(nodo);

            int index = visitado.indexOf(nodo);
            nodo = padre.get(index);
        }

        return camino;
    }
}