package Descartadas.Carolina.grafos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.grafos.componentes.Grafo;
import Descartadas.Carolina.grafos.componentes.Nodo;
import Descartadas.Carolina.grafos.metodos.CaminoMinimo;
import Descartadas.Carolina.grafos.metodos.ConsultasNobel;
import Descartadas.Carolina.grafos.metodos.GrafoDisjunto;
import Descartadas.Carolina.grafos.json.ArchivosJson;
import Descartadas.Carolina.grafos.json.Tripleta;

public class Main { //main del programa de grafos

    public static void main(String[] args) {

        //cargar JSON
        ArchivosJson loader = new ArchivosJson("datos.json");
        ListSE<Tripleta> datos = loader.cargar();


        //construir grafo
        Grafo g = new Grafo();
        g.cargarDesdeTripletas(datos);


        //mostrar grafo en formato árbol
        System.out.println("----- Representación del grafo -----");
        g.imprimirComoArbol();


        //metodo del camino mínimo
        System.out.println("----- Camino mínimo -----");

        CaminoMinimo cm = new CaminoMinimo(g); // creas el objeto con el grafo

        ListSE<Nodo> camino = cm.obtenerCamino("persona:Albert Einstein", "persona:Marie Curie"); // busca camino

        for (int i = 0; i < camino.getSize(); i++) { // imprime el camino
            System.out.print(camino.get(i).nombre);

            if (i < camino.getSize() - 1) System.out.print(" -> "); // separador
        }


        //metodo componentes conexas
        System.out.println("\n\n----- Componentes conexas -----");

        int componentes = GrafoDisjunto.contarComponentes(g); //calcula componentes

        System.out.println("Número de componentes: " + componentes); //lo muestra


        //consultas sobre los premios nobel
        System.out.println("\n----- Premios Nobel -----");

        System.out.println("1.Mismo premio");

        ListSE<String> resultado = ConsultasNobel.fisicosMismaCiudadQueEinstein(g); //

        if (resultado.getSize() == 0) { //si no hay resultados
            System.out.println("No hay resultados");
        }
        else {
            for (int i = 0; i < resultado.getSize(); i++) { //imprime resultados
                System.out.println(resultado.get(i));
            }
        }

        System.out.println("2.Lugares de nacimiento");

        ListSE<String> lugares = ConsultasNobel.lugaresNacimientoNobel(g); //segunda consulta

        for (int i = 0; i < lugares.getSize(); i++) { //imprime lista
            System.out.println(lugares.get(i));
        }
    }
}