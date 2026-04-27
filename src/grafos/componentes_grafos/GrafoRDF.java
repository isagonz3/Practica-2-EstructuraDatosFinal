package grafos.componentes_grafos;

import estructuras_necesarias.ListSE;
import estructuras_necesarias.MyIterate;
import grafos.algoritmos.UtilsString;

public class GrafoRDF implements GrafoBase {

    private ListSE<ParNodoAristas> adyacencia;
    private ListSE<String> nodos;
    private ListSE<TipoNodo> tipos;

    public GrafoRDF() {
        adyacencia = new ListSE<>();
        nodos = new ListSE<>();
        tipos = new ListSE<>();
    }

    private int buscarNodo(String id) {
        MyIterate<String> it = nodos.getIterate();
        int index = 0;

        while (it.hasNext()) {
            String actual = it.next();
            if (UtilsString.iguales(actual, id)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public void addNodo(String id) {
        if (buscarNodo(id) != -1) return;

        nodos.addLast(id);

        TipoNodo tipo;
        if (id.contains(":")) {
            String prefijo = id.substring(0, id.indexOf(":"));
            if (UtilsString.iguales(prefijo, "persona")) tipo = TipoNodo.PERSONA;
            else if (UtilsString.iguales(prefijo, "lugar")) tipo = TipoNodo.LUGAR;
            else if (UtilsString.iguales(prefijo, "premio")) tipo = TipoNodo.PREMIO;
            else if (UtilsString.iguales(prefijo, "tipo")) tipo = TipoNodo.TIPO;
            else tipo = TipoNodo.LITERAL;
        } else {
            tipo = TipoNodo.LITERAL;
        }

        tipos.addLast(tipo);
        adyacencia.addLast(new ParNodoAristas(id));
    }

    @Override
    public void addArista(String origen, String predicado, String destino) {
        addNodo(origen);
        addNodo(destino);

        int index = buscarNodo(origen);
        ParNodoAristas par = adyacencia.get(index);

        par.aristas.addLast(new Arista(destino, predicado));
    }

    @Override
    public boolean existeNodo(String id) {
        return buscarNodo(id) != -1;
    }

    @Override
    public ListSE<String> getVecinos(String id) {
        ListSE<String> vecinos = new ListSE<>();

        int index = buscarNodo(id);
        if (index == -1) return vecinos;

        ParNodoAristas par = adyacencia.get(index);
        MyIterate<Arista> it = par.aristas.getIterate();

        while (it.hasNext()) {
            vecinos.addLast(it.next().destino);
        }

        return vecinos;
    }

    public void cargarTripletas(ListSE<Tripleta> tripletas) {
        MyIterate<Tripleta> it = tripletas.getIterate();
        while (it.hasNext()) {
            Tripleta t = it.next();
            addArista(t.s, t.p, t.o);
        }
    }

    public String lugarNacimiento(String persona) {
        int index = buscarNodo(persona);
        if (index == -1) return null;

        ParNodoAristas par = adyacencia.get(index);
        MyIterate<Arista> it = par.aristas.getIterate();

        while (it.hasNext()) {
            Arista a = it.next();
            if (UtilsString.iguales(a.predicado, "nace_en")) {
                return a.destino;
            }
        }
        return null;
    }

    public boolean esPremioNobel(String persona) {
        int index = buscarNodo(persona);
        if (index == -1) return false;

        ParNodoAristas par = adyacencia.get(index);
        MyIterate<Arista> it = par.aristas.getIterate();

        while (it.hasNext()) {
            Arista a = it.next();
            if (UtilsString.iguales(a.predicado, "premio:Nobel")) {
                return true;
            }
        }
        return false;
    }

    public String mismoLugarQueEinstein() {
        String ciudad = lugarNacimiento("persona:Albert Einstein");

        MyIterate<String> it = nodos.getIterate();

        while (it.hasNext()) {
            String persona = it.next();

            if (!UtilsString.iguales(persona, "persona:Albert Einstein")) {
                String ciudad2 = lugarNacimiento(persona);

                if (ciudad != null && UtilsString.iguales(ciudad, ciudad2)) {
                    return persona;
                }
            }
        }
        return null;
    }
}