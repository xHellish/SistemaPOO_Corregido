package graphic.controllers;

import graphic.AccionesHabitatView;
import graphic.EliminarEspecieView;
import graphic.models.EliminarEspecieModel;

public class EliminarEspecieController {
	
	private EliminarEspecieModel modelo;
	private EliminarEspecieView vista;
	
	
	public EliminarEspecieController(EliminarEspecieModel modelo, EliminarEspecieView vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initEventHandlers();
	}
	
	private void initEventHandlers() {
        vista.getBorrarEspecieButton().addActionListener(e -> handleBorrarEspecieClick());
        
    }
	
	private void handleBorrarEspecieClick() {
		String especieEscrita = vista.getTexField();
		boolean existe = modelo.borrarEspecie(especieEscrita);
		
		if(existe) {
			System.out.println("Especie '"+ especieEscrita +"' eliminada exitosamente.");
			vista.dispose();
		}
		
		
		
		
	}
}