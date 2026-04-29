package Descartadas.Carolina.grafos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.grafos.componentes.Grafo;
import Descartadas.Carolina.grafos.componentes.Nodo;
import Descartadas.Carolina.grafos.ejercicios.CaminoMinimo;
import Descartadas.Carolina.grafos.ejercicios.ConsultasNobel;
import Descartadas.Carolina.grafos.ejercicios.GrafoDisjunto;
import Descartadas.Carolina.grafos.json.ArchivosJson;
import Descartadas.Carolina.grafos.json.Tripleta;

public class Main { //main del programa de grafos

    public static void main(String[] args) {

        // 1. cargar json
        ListSE<Tripleta> datos =
                ArchivosJson.cargar("datos.json"); //lee el archivo y saca las tripletas

        // 2. construir grafo
        Grafo g = new Grafo(); //crea el grafo vacío
        g.cargarDesdeTripletas(datos); //mete los datos en el grafo

        // 3. mostrar grafo
        System.out.println("===== GRAFO =====");

        for (int i = 0; i < g.nodos.getSize(); i++) { //recorre todos los nodos del grafo

            Nodo n = g.nodos.get(i); //nodo actual

            System.out.print(n.nombre + " -> "); //imprime el nodo

            for (int j = 0; j < n.aristas.getSize(); j++) { //recorre sus conexiones
                System.out.print(n.aristas.get(j).destino.nombre + " "); //imprime destinos
            }

            System.out.println(); //salto de línea
        }

        // =====================================================
        // camino mínimo
        // =====================================================
        System.out.println("\n===== CAMINO MÍNIMO =====");

        ListSE<Nodo> camino =
                CaminoMinimo.obtenerCamino(g, "persona:Albert Einstein", "persona:Marie Curie"); //busca camino

        for (int i = 0; i < camino.getSize(); i++) { //imprime el camino
            System.out.print(camino.get(i).nombre);

            if (i < camino.getSize() - 1) System.out.print(" -> "); //separador
        }

        // =====================================================
        // componentes conexas
        // =====================================================
        System.out.println("\n\n===== COMPONENTES CONEXAS =====");

        int componentes = GrafoDisjunto.contarComponentes(g); //calcula componentes

        System.out.println("Número de componentes: " + componentes); //lo muestra

        // =====================================================
        // consulta nobel
        // =====================================================
        System.out.println("\n===== CONSULTA NOBEL =====");

        ListSE<String> resultado =
                ConsultasNobel.fisicosMismaCiudadQueEinstein(g); //consulta principal

        if (resultado.getSize() == 0) { //si no hay resultados
            System.out.println("No hay resultados");
        } else {
            for (int i = 0; i < resultado.getSize(); i++) { //imprime resultados
                System.out.println(resultado.get(i));
            }
        }

        System.out.println("\n===== LUGARES NACIMIENTO NOBEL =====");

        ListSE<String> lugares =
                ConsultasNobel.lugaresNacimientoNobel(g); //segunda consulta

        for (int i = 0; i < lugares.getSize(); i++) { //imprime lista
            System.out.println(lugares.get(i));
        }
    }
}