package Descartadas.Carolina.grafos.ejercicios;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.estructuras_necesarias.Queue;
import Descartadas.Carolina.grafos.componentes.Grafo;
import Descartadas.Carolina.grafos.componentes.Nodo;

public class GrafoDisjunto { //clase para contar componentes conexas del grafo

    public static int contarComponentes(Grafo g) { //devuelve cuántos componentes conexos hay

        ListSE<Nodo> visitados = new ListSE<>(); //lista de nodos ya visitados
        int componentes = 0; //contador de componentes

        for (int i = 0; i < g.nodos.getSize(); i++) { //recorre todos los nodos del grafo

            Nodo n = g.nodos.get(i); //nodo actual

            if (!contiene(visitados, n)) { //si no se ha visitado todavía
                componentes++; //nuevo componente encontrado
                recorrer(n, visitados); //recorre todo el componente
            }
        }

        return componentes; //devuelve el número total de componentes
    }

    private static void recorrer(Nodo inicio, ListSE<Nodo> visitados) { //recorre un componente con bfs

        Queue<Nodo> cola = new Queue<>(); //cola para recorrer en anchura
        cola.enqueue(inicio); //mete el nodo inicial
        visitados.addLast(inicio); //lo marca como visitado

        while (!cola.isEmpty()) { //mientras haya nodos por visitar

            Nodo actual = cola.dequeue(); //saca el siguiente nodo

            for (int i = 0; i < actual.aristas.getSize(); i++) { //recorre sus conexiones

                Nodo sig = actual.aristas.get(i).destino; //nodo vecino

                if (!contiene(visitados, sig)) { //si no está visitado
                    visitados.addLast(sig); //lo marca como visitado
                    cola.enqueue(sig); //lo añade a la cola
                }
            }
        }
    }

    private static boolean contiene(ListSE<Nodo> lista, Nodo n) { //comprueba si un nodo está en la lista
        for (int i = 0; i < lista.getSize(); i++) { //recorre la lista
            if (lista.get(i) == n) return true; //si es el mismo nodo lo encuentra
        }
        return false; //si no está
    }
}