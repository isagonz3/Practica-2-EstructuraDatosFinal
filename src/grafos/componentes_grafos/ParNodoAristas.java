package grafos.componentes_grafos;

import estructuras_necesarias.ListSE;

public class ParNodoAristas implements Comparable<ParNodoAristas> {
    public String nodo;
    public ListSE<Arista> aristas;

    public ParNodoAristas(String nodo) {
        this.nodo = nodo;
        this.aristas = new ListSE<>();
    }

    @Override
    public int compareTo(ParNodoAristas o) {
        return 0;
    }
}