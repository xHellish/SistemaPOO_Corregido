package datos;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Especie;
import sistema.Habitat;

public class LectorJson {
    Vector<Habitat> habitatsVector = new Vector<Habitat>();

    public LectorJson(String ubicacionJson) {
        jsonAdmin(ubicacionJson);
    }

    public Vector<Habitat> getHabitatsVector() {
        return habitatsVector;
    }

    private void jsonAdmin(String filePath) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String nombreSinac = (String) jsonObject.get("nombre");
            JSONArray habitatArray = (JSONArray) jsonObject.get("hábitats");

            for (Object obj : habitatArray) {
                JSONObject habitatObject = (JSONObject) obj;
                String nombreHabitat = (String) habitatObject.get("nombre");
                JSONArray especiesArray = (JSONArray) habitatObject.get("especies");

                Vector<Especie> especies = new Vector<>();

                for (Object especieObj : especiesArray) {
                    JSONObject especieObject = (JSONObject) especieObj;
                    String nombreEspecie = (String) especieObject.get("nombre");
                    int porcentaje = ((Long) especieObject.get("porcentaje")).intValue();

                    Especie especie = new Especie(nombreEspecie, porcentaje);
                    especies.add(especie);
                }

                Habitat habitat = new Habitat(nombreHabitat, especies);
                habitatsVector.add(habitat);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
