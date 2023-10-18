package graphic.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Habitat;

public class EliminarEspecieModel {
	
	String rutaJson = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";
	Habitat habitat;
	
	public EliminarEspecieModel(Habitat habitat) {
		this.habitat = habitat;
	}
	
	public Habitat getHabitat() {
		return habitat;
	}
	
	public boolean borrarEspecie(String nombreHabitat, String especieToDelete) {
		
		nombreHabitat = habitat.getName();
		JSONParser parser = new JSONParser();

	    try (FileReader reader = new FileReader(rutaJson)) {
	        JSONObject jsonObject = (JSONObject) parser.parse(reader);
	        JSONArray habitatsArray = (JSONArray) jsonObject.get("hábitats");

	        for (Object obj : habitatsArray) {
	            JSONObject habitatObject = (JSONObject) obj;
	            String nombreHabitatJSON = (String) habitatObject.get("nombre");

	            if (nombreHabitat.equals(nombreHabitatJSON)) {
	                JSONArray especiesArray = (JSONArray) habitatObject.get("especies");

	                for (Object especieObj : especiesArray) {
	                    JSONObject especieObject = (JSONObject) especieObj;
	                    String nombreEspecieJSON = (String) especieObject.get("nombre");

	                    if (especieToDelete.equals(nombreEspecieJSON)) {
	                        especiesArray.remove(especieObj);
	                        break;
	                    }
	                }

	                break; // Terminar la búsqueda del hábitat
	            }
	        }

	        try (FileWriter fileWriter = new FileWriter(rutaJson)) {
	            fileWriter.write(jsonObject.toJSONString());
	            fileWriter.flush();
	        }
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
	    
		return habitat.deleteEspecie(especieToDelete);
	}
}
