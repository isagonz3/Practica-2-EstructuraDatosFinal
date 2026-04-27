package grafos.algoritmos;

import estructuras_necesarias.Queue;
import estructuras_necesarias.ListSE;
import estructuras_necesarias.MyIterate;
import grafos.componentes_grafos.GrafoBase;

public class ComponentesConexas {

    public static boolean esDisjunto(GrafoBase grafo, ListSE<String> todosLosNodos) {

        if (todosLosNodos.isEmpty()) return false;

        String inicio = todosLosNodos.get(0);

        Queue<String> cola = new Queue<>();
        ListSE<String> visitado = new ListSE<>();

        cola.enqueue(inicio);
        visitado.addLast(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.dequeue();

            ListSE<String> vecinos = grafo.getVecinos(actual);
            MyIterate<String> it = vecinos.getIterate();

            while (it.hasNext()) {
                String v = it.next();
                if (!visitado.contains(v)) {
                    visitado.addLast(v);
                    cola.enqueue(v);
                }
            }
        }

        return visitado.getSize() != todosLosNodos.getSize();
    }
}