package graphic.controllers;

import javax.swing.JButton;

import graphic.AccionesHabitatView;
import graphic.EliminarHabitatView;
import graphic.models.EliminarHabitatModel;

public class EliminarHabitatController {
	
	private EliminarHabitatModel modelo;
	private EliminarHabitatView vista;
	private AccionesHabitatView ventanaAcciones;
	
	public EliminarHabitatController(EliminarHabitatModel modelo, EliminarHabitatView vista, AccionesHabitatView ventanaAcciones) {
		this.modelo = modelo;
		this.vista = vista;
		this.ventanaAcciones = ventanaAcciones;
		
		vista.setTitle(modelo.getHabitatBorrar().getName());
		initActionListeners();
	}
	
	private void initActionListeners() {
		vista.getAceptarButton().addActionListener(e -> handleAceptarButtonClick());
		vista.getCancelarButton().addActionListener(e -> handleCancelarButtonClick());
	}
	
	private void handleAceptarButtonClick() {
		modelo.eliminarHabitat(modelo.getHabitatBorrar());
		vista.dispose();
		ventanaAcciones.dispose();
	}
	
	private void handleCancelarButtonClick(){
		vista.dispose();
	}
	
	public JButton getEliminarButton() {
		return vista.getAceptarButton();
	}
}

