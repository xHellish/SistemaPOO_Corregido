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

import sistema.Habitat;

public class LectorJson {
	
	String[] habitatsNombres;
	Vector<Habitat> habitatsVector = new Vector();
	Map<String, Integer> especiesMap = new HashMap<>();
	Map<String, Map<String, Integer>> distribucionHabitats = new HashMap<>();
	
	JSONParser parser = new JSONParser();
	
	public LectorJson (String ubicacionJson) {
		jsonAdmin(ubicacionJson);
		mapJasonEspecies(ubicacionJson);
		asignarEspeciesHabitat();
	}
	
	public Vector<Habitat> getHabitatsVector(){
		return habitatsVector;
	}
	
	private void mapJasonEspecies(String filePath) {
	    // Crear un analizador JSON-Simple
	    JSONParser parser = new JSONParser();

	    try (FileReader reader = new FileReader(filePath)) {
	        // Leer el contenido del archivo en una cadena
	        StringBuilder jsonContent = new StringBuilder();
	        int character;
	        while ((character = reader.read()) != -1) {
	            jsonContent.append((char) character);
	        }

	        // Analizar la cadena JSON en un objeto JSON
	        JSONObject jsonObject = (JSONObject) parser.parse(jsonContent.toString());

	        // Obtener el objeto "especies" del JSON
	        JSONObject especiesJson = (JSONObject) jsonObject.get("especies");

	        // Iterar a través de las claves y agregarlas al diccionario
	        for (Object key : especiesJson.keySet()) {
	            String especie = (String) key;
	            long cantidad = (long) especiesJson.get(key);
	            especiesMap.put(especie, (int) cantidad);
	        }
	        
	        /*
	        // Imprimir el diccionario
	        for (Map.Entry<String, Integer> entry : especiesMap.entrySet()) {
	            System.out.println("Especie: " + entry.getKey() + ", Cantidad: " + entry.getValue());
	        }
	        */
	        
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
	}

	private void asignarEspeciesHabitat() {
		
		// Inicializar los hábitats con 0 especies
        for (String habitat : habitatsNombres) {
            distribucionHabitats.put(habitat, new HashMap<>());
        }
        
        for (String especie : especiesMap.keySet()) {
            int cantidad = especiesMap.get(especie);

            for (int i = 0; i < cantidad; i++) {
                // Escoge aleatoriamente un hábitat
                String habitatAleatorio = habitatsNombres[ThreadLocalRandom.current().nextInt(habitatsNombres.length)];

                // Incrementa la cantidad de esa especie en el hábitat seleccionado
                Map<String, Integer> habitat = distribucionHabitats.get(habitatAleatorio);
                habitat.put(especie, habitat.getOrDefault(especie, 0) + 1);
            }
        }
        
        /*
        // Imprimir la distribución de especies en los hábitats
        for (String habitat : habitatsNombres) {
            Map<String, Integer> distribucion = distribucionHabitats.get(habitat);
            System.out.println("Hábitat: " + habitat);
            
            for (Map.Entry<String, Integer> entry : distribucion.entrySet()) {
                System.out.println("  Especie: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }
        }
        
        */
        
        // Asignar las especies a los hábitats en habitatsVector
        for (int i = 0; i < habitatsNombres.length; i++) {
            Habitat habitat = habitatsVector.elementAt(i);
            Map<String, Integer> especiesHabitat = distribucionHabitats.get(habitatsNombres[i]);
            habitat.setEspecies(especiesHabitat);
        }
        
        
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
            
            for (String habitat : habitatsNombres) {
            	Habitat habitatObjeto = new Habitat(habitat);
            	habitatsVector.add(habitatObjeto);
            }
        
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }   
    }
}
