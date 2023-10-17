package graphic.controllers;

import exeptions.ExeptionBenFarz;
import graphic.AccionesHabitatView;
import graphic.AgregarHabitatView;
import graphic.VentanaPrincipalView;
import graphic.models.AccionesHabitatModel;
import graphic.models.AgregarHabitatModel;
import graphic.models.VentanaPrincipalModel;
import sistema.Habitat;

public class VentanaPrincipalController {
	
	private VentanaPrincipalModel modelo;
    private VentanaPrincipalView vista;
    
    private AgregarHabitatController agregarHabitat;
    private AccionesHabitatController accionesHabitat;
    
    //private EliminarHabitat _eliminarHabitat;
    //private EliminarEspecie _eliminarEspecie;
    //private AgregarEspecie _agregarEspecie;
    
	public VentanaPrincipalController(VentanaPrincipalModel modelo, VentanaPrincipalView vista){
		this.modelo = modelo;
		this.vista = vista;
		
		initEventHandlers(); // Inicializar listeners.
		initUI(); // Inicializar construcciones faltantes de la ventana.
	}
	
	private void initEventHandlers() {
        vista.getAccionesButton().addActionListener(e -> handleAccionesButtonClick());
        vista.getActualizarButton().addActionListener(e -> handleActualizarButtonClick());
        vista.getAgregarHabitatButton().addActionListener(e -> handleAgregarHabitatButtonClick());
    }
	
	// -------------------------------- Función de cada listener -------------------------------- //
	// AccionesButton.
	private void handleAccionesButtonClick() {
		
		String habitatSeleccionadoStr = vista.getComboboxTxt();
    	Habitat habitatSeleccionado = null;
    	
    	for (Habitat tmp : modelo.getHabitatsVector()) {
			if (tmp.getName() == habitatSeleccionadoStr && tmp.getName() == "") {
				throw new ExeptionBenFarz("Nombre de Habitat vacío.");
				
			}else if (tmp.getName() == habitatSeleccionadoStr) {
				habitatSeleccionado = tmp;
			}
		}
    	
    	if (habitatSeleccionado != null) {
    		AccionesHabitatModel accionesModelo = new AccionesHabitatModel(modelo.getHabitatsVector(), habitatSeleccionado);
    		AccionesHabitatView accionesVista = new AccionesHabitatView();
    		accionesVista.setNombre(habitatSeleccionadoStr);
    		accionesHabitat = new AccionesHabitatController(accionesModelo, accionesVista);
    		accionesVista.setBounds(740, 240, 450, 225);
    		accionesVista.setVisible(true);
    	}
	}
	
	// ActualizarButton.
	private void handleActualizarButtonClick() {
		initUI();
	}
	
	// AgregarHabitatButton.
	private void handleAgregarHabitatButtonClick() {
		AgregarHabitatModel agregarHabitatModelo = new AgregarHabitatModel(modelo.getHabitatsVector());
		AgregarHabitatView agregarHabitatVista = new AgregarHabitatView();
		agregarHabitat = new AgregarHabitatController(agregarHabitatModelo, agregarHabitatVista);
		agregarHabitatVista.setBounds(740, 100, 350, 140);
		agregarHabitatVista.setVisible(true);
	}
	
	// Construir UI.
	private void initUI() {
		vista.construirVentana(modelo.getHabitatsVector());
		vista.setVisible(true);
	}

}


