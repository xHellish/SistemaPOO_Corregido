package graphic.controllers;

import graphic.AgregarHabitatView;
import graphic.models.AgregarHabitatModel;
import sistema.Habitat;

public class AgregarHabitatController {
	
	private AgregarHabitatModel modelo;
	private AgregarHabitatView vista;
	
	public AgregarHabitatController(AgregarHabitatModel modelo, AgregarHabitatView vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initEventHandlers(); // Inicializar listeners.
	}
	
	private void initEventHandlers() {
        vista.getBotonAceptar().addActionListener(e -> handleAceptarClick());
        vista.getBotonCancelar().addActionListener(e -> handleCancelarClick());
    }
	
	// Eventos.
	private void handleAceptarClick() {
		String habitatNombre = vista.getTextField();
		boolean existe = false;
		boolean vacio = false;
		
		if (habitatNombre.equals("")) {
			vacio = true;
			vista.alerta("Nombre vacío", "Error");
			
		} else {
			for (Habitat tmp : modelo.getHabitats()) {
				if (tmp.getName().equals(habitatNombre)) {
					vista.alerta("Habitat ya existe", "Error");
					existe = true;
				}
			}
		}
		
		if (!existe && !vacio) {
			modelo.agregarNuevoHabitat(habitatNombre);
			System.out.println("Se ha añadido nuevo habitat");
			vista.dispose();
		}
	}
	
	private void handleCancelarClick() {
		vista.dispose();
	}
}
