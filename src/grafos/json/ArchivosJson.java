package grafos.json;

import com.google.gson.Gson;
import estructuras_necesarias.ListSE;
import grafos.componentes_grafos.Tripleta;

import java.io.FileReader;

public class ArchivosJson {

    private static class ContenedorTripletas {
        Tripleta[] tripletas;
    }

    public static ListSE<Tripleta> cargar(String ruta) {
        ListSE<Tripleta> lista = new ListSE<>();

        try {
            Gson gson = new Gson();

            ContenedorTripletas data =
                    gson.fromJson(new FileReader(ruta), ContenedorTripletas.class);

            if (data != null && data.tripletas != null) {
                for (int i = 0; i < data.tripletas.length; i++) {
                    lista.addLast(data.tripletas[i]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}