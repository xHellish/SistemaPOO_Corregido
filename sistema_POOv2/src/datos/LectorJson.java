package datos;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Habitat;

public class LectorJson {
	
	String[] habitatsNombres;
	Vector<Habitat> habitatsVector = new Vector();
	
	JSONParser parser = new JSONParser();
	
	public LectorJson (String ubicacionAdmin) {
		
		jsonAdmin(ubicacionAdmin); 
		
		
	}
	
	private void jsonAdmin(String filePath) {
		
        try (FileReader reader = new FileReader(filePath)) {
            // Analizar el archivo JSON
            Object obj = parser.parse(reader);

            // Convertir el objeto JSON en JSONObject. 
            JSONObject _jsonObject = (JSONObject) obj;

            // Obtener la matriz JSON bajo la clave correspondiente.
            JSONArray habitatsJSON = (JSONArray) _jsonObject.get("hábitats");
    
            // Convertir array de json en array de java.
            habitatsNombres = new String[habitatsJSON.size()];
            
            for (int i = 0; i < habitatsNombres.length; i++) {
            	habitatsNombres[i] = (String) habitatsJSON.get(i);
            }
            
        
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
    }

}
