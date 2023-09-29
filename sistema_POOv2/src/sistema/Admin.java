package sistema;

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
		
		// Main window
		VentanaPrincipal ventanaMain = new VentanaPrincipal();
		ventanaMain.setVisible(true);
		
	}
	
	
	
	
	
	
	
	// Main metod.
	public static void main(String[] args) {
		Admin programa = new Admin();
	}
}
