package Seleccionadas.grafos;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public final class ParserJSON {

    public static void cargarGrafo(String rutaArchivo, GrafoDeConocimiento grafo) {
        try(FileReader fr = new FileReader(rutaArchivo)){
            JsonObject json = JsonParser.parseReader(fr).getAsJsonObject();
            JsonArray triples = json.getAsJsonArray("Triples");

            for(int i = 0; i < triples.size(); i++){
                JsonObject triple = triples.get(i).getAsJsonObject();
                String subject = triple.get("s").getAsString();
                String predicate = triple.get("p").getAsString();
                String object = triple.get("o").getAsString();

                grafo.addTriple(subject, predicate, object);
            }

        }
        catch(Exception e){
            System.err.println("Error al cargar grafo: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
