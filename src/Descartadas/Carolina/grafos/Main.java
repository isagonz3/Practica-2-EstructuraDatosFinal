package Descartadas.Carolina.grafos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.grafos.algoritmos.BFS;
import Descartadas.Carolina.grafos.algoritmos.ComponentesConexas;
import Descartadas.Carolina.grafos.componentes_grafos.GrafoRDF;
import Descartadas.Carolina.grafos.componentes_grafos.Tripleta;
import Descartadas.Carolina.grafos.json.ArchivosJson;

public class Main {

    public static void main(String[] args) {

        ListSE<Tripleta> tripletas = ArchivosJson.cargar("datos.json");

        GrafoRDF grafo = new GrafoRDF();
        grafo.cargarTripletas(tripletas);

        System.out.println("Lugar de nacimiento de Einstein:");
        System.out.println(grafo.lugarNacimiento("persona:Albert Einstein"));

        System.out.println("\nCamino mínimo entre Einstein y Ulm:");
        System.out.println(
                BFS.caminoMinimo(
                        grafo,
                        "persona:Albert Einstein",
                        "lugar:Ulm"
                )
        );

        ListSE<String> nodos = new ListSE<>();
        nodos.addLast("persona:Albert Einstein");
        nodos.addLast("lugar:Ulm");
        nodos.addLast("persona:Marie Curie");
        nodos.addLast("lugar:Varsovia");

        System.out.println("\n¿El grafo es disjunto?");
        System.out.println(
                ComponentesConexas.esDisjunto(grafo, nodos)
        );

        System.out.println("\nPersona nacida en el mismo lugar que Einstein:");
        System.out.println(
                grafo.mismoLugarQueEinstein()
        );
    }
}