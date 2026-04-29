package Descartadas.Carolina.grafos.métodos;

import Descartadas.Carolina.estructuras_necesarias.ListSE;
import Descartadas.Carolina.grafos.componentes.Arista;
import Descartadas.Carolina.grafos.componentes.Grafo;
import Descartadas.Carolina.grafos.componentes.Nodo;

public class ConsultasNobel { //consultas sobre personas con premio nobel en el grafo

    public static ListSE<String> fisicosMismaCiudadQueEinstein(Grafo g) { //devuelve físicos nobel nacidos en la misma ciudad que einstein

        Nodo einstein = g.buscarNodo("persona:Albert Einstein"); //busca el nodo de einstein
        ListSE<String> resultado = new ListSE<>(); //lista de resultados

        if (einstein == null) return resultado; //si no existe einstein no se puede hacer nada

        String ciudadEinstein = null; //guardará la ciudad de nacimiento de einstein

        for (int i = 0; i < einstein.aristas.getSize(); i++) { //recorre sus relaciones
            Arista a = einstein.aristas.get(i); //coge cada arista

            if (a.etiqueta.equals("nace_en")) { //si es la relación de nacimiento
                ciudadEinstein = a.destino.nombre; //guarda la ciudad
            }
        }

        if (ciudadEinstein == null) return resultado; //si no tiene ciudad se sale

        for (int i = 0; i < g.nodos.getSize(); i++) { //recorre todos los nodos del grafo

            Nodo n = g.nodos.get(i); //coge cada nodo

            if (!n.nombre.startsWith("persona:")) continue; //solo personas
            if (n.nombre.equals("persona:Albert Einstein")) continue; //ignora a einstein

            boolean esNobel = false; //marca si tiene nobel
            String ciudad = null; //ciudad de nacimiento del nodo actual

            for (int j = 0; j < n.aristas.getSize(); j++) { //recorre sus aristas

                Arista a = n.aristas.get(j); //coge la arista

                if (a.etiqueta.equals("premio:Nobel")) { //si tiene nobel
                    esNobel = true;
                }

                if (a.etiqueta.equals("nace_en")) { //si tiene ciudad de nacimiento
                    ciudad = a.destino.nombre;
                }
            }

            if (esNobel && ciudad != null && ciudad.equals(ciudadEinstein)) { //si cumple condiciones
                resultado.addLast(n.nombre); //se añade al resultado
            }
        }

        return resultado; //devuelve la lista final
    }

    public static ListSE<String> lugaresNacimientoNobel(Grafo g) { //devuelve lugares de nacimiento de personas con nobel

        ListSE<String> resultado = new ListSE<>(); //lista resultado

        for (int i = 0; i < g.nodos.getSize(); i++) { //recorre todos los nodos

            Nodo n = g.nodos.get(i); //nodo actual

            if (!n.nombre.startsWith("persona:")) continue; //solo personas

            boolean esNobel = false; //si tiene nobel
            String lugar = null; //lugar de nacimiento

            for (int j = 0; j < n.aristas.getSize(); j++) { //recorre aristas

                Arista a = n.aristas.get(j); //arista actual

                if (a.etiqueta.equals("premio:Nobel")) { //marca nobel
                    esNobel = true;
                }

                if (a.etiqueta.equals("nace_en")) { //guarda nacimiento
                    lugar = a.destino.nombre;
                }
            }

            if (esNobel && lugar != null) { //si cumple condiciones
                resultado.addLast(lugar); //añade lugar
            }
        }

        return resultado; //devuelve resultado final
    }
}