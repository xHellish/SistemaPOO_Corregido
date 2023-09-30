package sistema;

import java.util.Vector;

import datos.LectorJson;
import graphic.VentanaPrincipal;

public class Admin {
	
	String rutaJsonAdmin = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";
	
	public Admin() {
		// Thread principal.
		TimerTick timer = new TimerTick();
		
		// Json Parser.
		LectorJson parserDatosJason = new LectorJson(rutaJsonAdmin);
		
		// Creador de los habitats.
		Vector<Habitat> habitatsVector = parserDatosJason.getHabitatsVector();
		
		/* Imprimir las especies de cada habitat. (depurar)

		for (int i = 0; i < habitatsVector.size(); i++) {
			System.out.println("Habitat: "+ habitatsVector.elementAt(i).nombreHabitat + ": "+ habitatsVector.elementAt(i).getEspecies()); 
		}
		
		for (Habitat habitatObj : habitatsVector) {
			System.out.println(habitatObj.getName());
		} 
		*/
		
		// Main window
		VentanaPrincipal ventanaMain = new VentanaPrincipal(habitatsVector);
		ventanaMain.setVisible(true);
		
	}
	
	// Main metod.
	public static void main(String[] args) {
		Admin programa = new Admin();
	}
}
