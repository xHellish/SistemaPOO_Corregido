package graphic.controllers;

import javax.swing.JButton;

import graphic.AccionesHabitatView;
import graphic.AgregarEspecieView;
import graphic.EliminarEspecieView;
import graphic.EliminarHabitatView;
import graphic.models.AccionesHabitatModel;
import graphic.models.AgregarEspecieModel;
import graphic.models.EliminarEspecieModel;
import graphic.models.EliminarHabitatModel;

public class AccionesHabitatController {
	
	private AccionesHabitatModel modelo;
	private AccionesHabitatView vista;
	
	private AgregarEspecieController agregarEspecie;
	private EliminarHabitatController eliminarHabitat;
	private EliminarEspecieController eliminarEspecie;
	
	public AccionesHabitatController (AccionesHabitatModel modelo, AccionesHabitatView vista){
		this.modelo = modelo;
		this.vista = vista;
		
		vista.setTitle(modelo.getHabitat().getName());
		
		initEventHandlers(); // Inicializar listeners.
	}
	
	private void initEventHandlers() {
		vista.getAgregarEspecieButton().addActionListener(e -> handleAgregarEspecieClick());
		vista.getEliminarEspecieButton().addActionListener(e -> handleEliminarEspecieClick());
		vista.getEliminarHabitatButton().addActionListener(e -> handleEliminarHabitatClick());
		
	}
	
	// Eventos.
	private void handleAgregarEspecieClick() {
		AgregarEspecieModel agregarEspecieModelo = new AgregarEspecieModel(modelo.getHabitat());
		AgregarEspecieView agregarEspecieVista = new AgregarEspecieView();
		
		agregarEspecieVista.setLocationRelativeTo(null);
		agregarEspecie = new AgregarEspecieController(agregarEspecieModelo, agregarEspecieVista);
		agregarEspecieVista.setVisible(true);
		
	}
	
	private void handleEliminarEspecieClick() {
		EliminarEspecieModel eliminarEspecieModelo = new EliminarEspecieModel(modelo.getHabitat());
		EliminarEspecieView eliminarEspecieVista = new EliminarEspecieView();
		
		eliminarEspecieVista.setLocationRelativeTo(null);
		eliminarEspecie = new EliminarEspecieController(eliminarEspecieModelo, eliminarEspecieVista);
		eliminarEspecieVista.setVisible(true);
	}
	
	private void handleEliminarHabitatClick() {
		EliminarHabitatModel eliminarHabitatModelo = new EliminarHabitatModel(modelo.getHabitatVector(), modelo.getHabitat());
		EliminarHabitatView eliminarHabitatVista = new EliminarHabitatView();
		
		eliminarHabitatVista.setTitle(modelo.getHabitat().getName());
		eliminarHabitatVista.setLocationRelativeTo(null);
		eliminarHabitat = new EliminarHabitatController(eliminarHabitatModelo, eliminarHabitatVista, vista);
		eliminarHabitatVista.setVisible(true);
	}

}
