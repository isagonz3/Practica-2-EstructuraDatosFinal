package Descartadas.Carolina.grafos.métodos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.estructuras_necesarias.Queue;
import Descartadas.Carolina.grafos.componentes.Grafo;
import Descartadas.Carolina.grafos.componentes.Nodo;

public class CaminoMinimo { //clase que calcula un camino mínimo usando búsqueda en anchura (bfs)

    public static ListSE<Nodo> obtenerCamino(Grafo g, String inicio, String fin) { //devuelve el camino entre dos nodos

        Nodo nodoInicio = g.buscarNodo(inicio); //busca el nodo de inicio en el grafo
        Nodo nodoFin = g.buscarNodo(fin); //busca el nodo final en el grafo

        ListSE<Nodo> caminoVacio = new ListSE<>(); //lista vacía por si no hay camino

        if (nodoInicio == null || nodoFin == null) { //si alguno no existe se devuelve vacío
            return caminoVacio;
        }

        Queue<Nodo> cola = new Queue<>(); //cola para hacer bfs
        ListSE<Nodo> visitados = new ListSE<>(); //lista de nodos ya visitados
        ListSE<Nodo> padres = new ListSE<>(); //lista paralela para guardar el padre de cada nodo

        cola.enqueue(nodoInicio); //metemos el nodo inicial en la cola
        visitados.addLast(nodoInicio); //marcamos como visitado el inicio
        padres.addLast(null); //el inicio no tiene padre

        boolean encontrado = false; //controla si ya hemos llegado al destino

        while (!cola.isEmpty() && !encontrado) { //mientras haya nodos y no se haya encontrado el fin

            Nodo actual = cola.dequeue(); //saca el siguiente nodo

            if (actual.nombre.equals(nodoFin.nombre)) { //si es el nodo final se termina
                encontrado = true;
            }

            for (int i = 0; i < actual.aristas.getSize() && !encontrado; i++) { //recorre sus conexiones

                Nodo siguiente = actual.aristas.get(i).destino; //obtiene el nodo vecino

                if (!contiene(visitados, siguiente)) { //si no se ha visitado
                    cola.enqueue(siguiente); //se mete en la cola
                    visitados.addLast(siguiente); //se marca como visitado
                    padres.addLast(actual); //se guarda su padre

                    if (siguiente.nombre.equals(nodoFin.nombre)) { //si es el destino paramos
                        encontrado = true;
                    }
                }
            }
        }

        return reconstruirCamino(nodoInicio, nodoFin, visitados, padres); //reconstruye el camino final
    }

    private static boolean contiene(ListSE<Nodo> lista, Nodo n) { //comprueba si un nodo está en una lista
        for (int i = 0; i < lista.getSize(); i++) { //recorre la lista
            if (lista.get(i).nombre.equals(n.nombre)) return true; //si coincide el nombre está dentro
        }
        return false; //si no se encuentra
    }

    private static ListSE<Nodo> reconstruirCamino(
            Nodo inicio, Nodo fin,
            ListSE<Nodo> visitados,
            ListSE<Nodo> padres) { //reconstruye el camino usando la lista de padres

        ListSE<Nodo> camino = new ListSE<>(); //lista final del camino

        int pos = -1; //posición del nodo final en visitados

        for (int i = 0; i < visitados.getSize(); i++) { //busca el nodo final
            if (visitados.get(i).nombre.equals(fin.nombre)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) return camino; //si no se encontró no hay camino

        Nodo actual = fin; //empieza desde el final

        ListSE<Nodo> caminoReves = new ListSE<>(); //camino al revés

        while (actual != null) { //mientras haya nodos padres
            caminoReves.addLast(actual); //se añade el nodo actual

            int index = indiceDeNodo(visitados, actual); //busca su índice
            if (index == -1) break; //si no está se corta

            actual = padres.get(index); //sube al padre
        }

        for (int i = caminoReves.getSize() - 1; i >= 0; i--) { //invierte el camino
            camino.addLast(caminoReves.get(i));
        }

        return camino; //devuelve el camino correcto
    }

    private static int indiceDeNodo(ListSE<Nodo> lista, Nodo n) { //devuelve el índice de un nodo
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.get(i).nombre.equals(n.nombre)) return i;
        }
        return -1;
    }
}