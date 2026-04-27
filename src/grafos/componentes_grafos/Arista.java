package grafos.componentes_grafos;

public class Arista implements Comparable<Arista> {
    public String destino;
    public String predicado;

    public Arista(String destino, String predicado) {
        this.destino = destino;
        this.predicado = predicado;
    }

    @Override
    public int compareTo(Arista o) {
        return 0;
    }
}