package sistema;

import graphic.VentanaPrincipalView;
import graphic.controllers.VentanaPrincipalController;
import graphic.models.VentanaPrincipalModel;

public class Admin {
	
	public Admin() {
		VentanaPrincipalModel modelo = new VentanaPrincipalModel();
		VentanaPrincipalView vista = new VentanaPrincipalView();
		VentanaPrincipalController controller = new VentanaPrincipalController(modelo, vista);
	}
	
	// Main metod.
	public static void main(String[] args) {
		Admin programa = new Admin();
	}
}
