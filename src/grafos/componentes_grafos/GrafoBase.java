package grafos.componentes_grafos;

import estructuras_necesarias.ListSE;

public interface GrafoBase {

    void addNodo(String id);

    void addArista(String origen, String predicado, String destino);

    boolean existeNodo(String id);

    ListSE<String> getVecinos(String id);
}