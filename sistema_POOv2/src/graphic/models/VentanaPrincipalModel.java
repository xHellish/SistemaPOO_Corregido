package graphic.models;

import java.util.Vector;

import datos.LectorJson;
import sistema.Habitat;

public class VentanaPrincipalModel {
	
	String rutaJsonAdmin = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";
	LectorJson parserDatosJason; 
	Vector<Habitat> habitatsVector; 
	
	public VentanaPrincipalModel(){
		
		parserDatosJason = new LectorJson(rutaJsonAdmin);
		habitatsVector = parserDatosJason.getHabitatsVector(); // Creador de los habitats.
		
		
		
	}

	public Vector<Habitat> getHabitatsVector() {
		return habitatsVector;
	}

}

// Imprimir las especies de cada habitat. (depurar)
/*
for (int i = 0; i < habitatsVector.size(); i++) {
	System.out.println("Habitat: "+ habitatsVector.elementAt(i).getName() + ": "+ habitatsVector.elementAt(i).getEspecies()); 
}
for (Habitat habitatObj : habitatsVector) {
	System.out.println(habitatObj.getName());
} 
*/

