package graphic.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Habitat;

public class EliminarHabitatModel {
    private String archivoJSON = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";
    private Vector<Habitat> habitats;
    private Habitat habitatToDelete;

    public EliminarHabitatModel(Vector<Habitat> habitats, Habitat habitatToDelete) {
        this.habitats = habitats;
        this.habitatToDelete = habitatToDelete;
    }

    public boolean eliminarHabitat(Habitat habitatToDelete) {
        String habitatEliminar = habitatToDelete.getName();

        for (Habitat tmp : habitats) {
            if (tmp.getName().equals(habitatEliminar)) {
                habitats.remove(tmp);
                break;
            }
        }

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(archivoJSON));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray habitatsJSON = (JSONArray) jsonObject.get("hábitats");
            
            // Buscar y eliminar el hábitat en el JSON
            for (int i = 0; i < habitatsJSON.size(); i++) {
                JSONObject habitatObj = (JSONObject) habitatsJSON.get(i);
                String nombreHabitat = (String) habitatObj.get("nombre");

                if (nombreHabitat.equals(habitatEliminar)) {
                    habitatsJSON.remove(i);
                    break;
                }
            }

            // Guardar el objeto JSON actualizado en el archivo
            try (FileWriter fileWriter = new FileWriter(archivoJSON)) {
                fileWriter.write(jsonObject.toJSONString());
                System.out.println("Hábitat '" + habitatEliminar + "' eliminado con éxito.");
            } catch (IOException e1) {
                System.err.println("Error al guardar el archivo JSON: " + e1.getMessage());
            }
        } catch (IOException | ParseException e1) {
            System.err.println("Error al leer o parsear el archivo JSON: " + e1.getMessage());
        }

        return true; // Siempre retorna true si llega a este punto, ya que intentó eliminar el hábitat
    }

    public Habitat getHabitatBorrar() {
        return habitatToDelete;
    }
}
