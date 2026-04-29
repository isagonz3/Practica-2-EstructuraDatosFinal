package Descartadas.Carolina.grafos.componentes;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.grafos.json.ArchivosJson;
import Descartadas.Carolina.grafos.json.Tripleta;

public class MainGrafo { //main de prueba del grafo básico

    public static void main(String[] args) {

        // 1. Cargar JSON
        ListSE<Tripleta> datos = ArchivosJson.cargar("datos.json");

        // 2. Construir grafo
        Grafo g = new Grafo();
        g.cargarDesdeTripletas(datos);

        // 3. Mostrar grafo en formato árbol
        System.out.println("===== GRAFO (FORMATO ÁRBOL) =====\n");
        g.imprimirComoArbol();

        // ===== tripletas (rdf real) =====
        System.out.println("===== TRIPLETAS RDF =====");

        for (int i = 0; i < g.tripletas.getSize(); i++) { //recorre tripletas

            Tripleta t = g.tripletas.get(i); //tripleta actual

            System.out.println( //imprime formato rdf
                    "<" + t.s + "> " +
                            "<" + t.p + "> " +
                            "<" + t.o + "> ."
            );
        }

        // ===== buscar nodo =====
        System.out.println("\n===== BUSCAR NODO: Juan =====");

        // buscar nodo dentro del grafo cargado
        Nodo buscado = g.buscarNodo("persona:Albert Einstein");

        if (buscado != null) {

            System.out.println("Nodo encontrado: " + buscado.nombre);

            for (int i = 0; i < buscado.aristas.getSize(); i++) {

                Arista a = buscado.aristas.get(i);

                System.out.println("  --[" + a.etiqueta + "]--> " + a.destino.nombre);
            }

        } else {
            System.out.println("Nodo no encontrado");
        }
    }
}