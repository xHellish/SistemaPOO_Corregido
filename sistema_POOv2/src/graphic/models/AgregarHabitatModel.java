package graphic.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Especie;
import sistema.Habitat;

public class AgregarHabitatModel {
    private Vector<Habitat> habitatsVector;

    public AgregarHabitatModel(Vector<Habitat> habitatsVector) {
        this.habitatsVector = habitatsVector;
    }

    public Vector<Habitat> getHabitats() {
        return habitatsVector;
    }

    public void agregarNuevoHabitat(String nombre) {
    	habitatsVector.add(new Habitat(nombre, new Vector<Especie>()));

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json")) {
            JSONObject rootNode = (JSONObject) parser.parse(reader);

            if (rootNode.containsKey("hábitats") && rootNode.get("hábitats") instanceof JSONArray) {
                JSONArray habitatsArray = (JSONArray) rootNode.get("hábitats");
                JSONObject nuevoHabitat = new JSONObject();
                nuevoHabitat.put("nombre", nombre);
                nuevoHabitat.put("especies", new JSONArray());
                habitatsArray.add(nuevoHabitat);
            } else {
                JSONArray newHabitatsArray = new JSONArray();
                JSONObject nuevoHabitat = new JSONObject();
                nuevoHabitat.put("nombre", nombre);
                nuevoHabitat.put("especies", new JSONArray());
                newHabitatsArray.add(nuevoHabitat);
                rootNode.put("hábitats", newHabitatsArray);
            }

            try (FileWriter fileWriter = new FileWriter("C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json")) {
                fileWriter.write(rootNode.toJSONString());
                fileWriter.flush();
            }

            System.out.println("Nuevo hábitat '" + nombre + "' agregado exitosamente.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
