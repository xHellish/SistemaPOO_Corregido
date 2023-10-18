package graphic.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Especie;
import sistema.Habitat;

public class AgregarEspecieModel {
	
	String archivoJSON = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";
	private Habitat habitat;
	
	public AgregarEspecieModel(Habitat habitat) {
		this.habitat = habitat;
		
	}
	
	public void agregarEspecie(Especie nuevaEspecie) {
		habitat.addEspecie(nuevaEspecie);
		
		String nombreHabitat = habitat.getName();
		
		try (FileReader reader = new FileReader(archivoJSON)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONArray habitatsArray = (JSONArray) jsonObject.get("hábitats");

            // Buscar el hábitat por nombre
            for (Object habitatObj : habitatsArray) {
                JSONObject habitat = (JSONObject) habitatObj;
                String nombre = (String) habitat.get("nombre");

                if (nombre.equals(nombreHabitat)) {
                    JSONArray especiesArray = (JSONArray) habitat.get("especies");

                    // Crear un objeto JSON para la nueva especie
                    JSONObject nuevaEspecieJSON = new JSONObject();
                    nuevaEspecieJSON.put("nombre", nuevaEspecie.getName());
                    nuevaEspecieJSON.put("porcentaje", nuevaEspecie.getPorcent());

                    // Agregar la nueva especie al arreglo de especies
                    especiesArray.add(nuevaEspecieJSON);

                    // Guardar el objeto JSON actualizado en el archivo
                    try (FileWriter fileWriter = new FileWriter(archivoJSON)) {
                        fileWriter.write(jsonObject.toJSONString());
                        System.out.println("Nueva especie agregada al hábitat '" + nombreHabitat + "'");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return;
                }
            }

            System.err.println("Hábitat '" + nombreHabitat + "' no encontrado en el archivo JSON.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		
	}
	
	public Habitat getHabitat() {
		return habitat;
	}

}
