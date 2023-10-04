package sistema;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Habitat {
	
	String nombreHabitat;
	Map<String, Integer> especiesMapDist = new HashMap<>();
	Vector<Especie> especiesVector = new Vector();
	
	public Habitat(String nombreHabitat) {
		this.nombreHabitat = nombreHabitat;
	}
	
	public String getName() {
		return nombreHabitat;
	}
	
	public void setEspecies(Map<String, Integer> diccionarioEspecie) {
		especiesMapDist.putAll(diccionarioEspecie);
		
		for (Map.Entry<String, Integer> entry : especiesMapDist.entrySet()) {
			especiesVector.add(new Especie(entry.getKey(), entry.getValue()));
			
			// Llave: entry.getKey() ------>  Valor: entry.getValue());
        }
	}
	
	public Map<String, Integer> getEspecies() {
        return especiesMapDist;
    }
	
	public Vector<Especie> getVectorEspecies() {
		return especiesVector;
	}
	
	public void addEspecie(Especie especieNueva) {
		especiesVector.add(especieNueva);
	}
	
	public boolean deleteEspecie(String nombreEspecie) {
		for (Especie tmp : especiesVector) {
			if (tmp.getName().equals(nombreEspecie)) {
				especiesVector.remove(tmp);
				return true;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Especie no existe",  "Error", JOptionPane.WARNING_MESSAGE);
		return false;
	}
}	
