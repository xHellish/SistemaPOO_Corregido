package graphic.controllers;

import javax.swing.JOptionPane;

import graphic.AgregarEspecieView;
import graphic.models.AgregarEspecieModel;
import sistema.Especie;

public class AgregarEspecieController {
	
	private AgregarEspecieModel modelo;
	private AgregarEspecieView vista;
	
	public AgregarEspecieController(AgregarEspecieModel modelo, AgregarEspecieView vista) {
		this.modelo = modelo;
		this.vista = vista;
		initEventHandlers(); // Inicializar eventos.
	}
	
	private void initEventHandlers() {
        vista.getAceptarButton().addActionListener(e -> handleAcceptarButtonClick());
    }
	
	// Eventos.
	private void handleAcceptarButtonClick() {
		if (vista.getTextFieldNombre().equals("")) {
		    JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		} else if (vista.getTextFieldPorcentaje().equals("")) {
		    JOptionPane.showMessageDialog(null, "Porcentaje no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		} else {
		    String nombre = vista.getTextFieldNombre();
		    int porcentaje = Integer.parseInt(vista.getTextFieldPorcentaje());
		    Especie especieAgregada = new Especie(nombre, porcentaje); // Crear instancia de especie.
		    
		    if (modelo.getHabitat().porcentajeDisponible(especieAgregada)) {
		    	modelo.agregarEspecie(especieAgregada);
		    	System.out.println("Nombre: " + especieAgregada.getName());
			    System.out.println("Porcentaje: " + especieAgregada.getPorcent());
			    vista.dispose();
		    } else {
		    	JOptionPane.showMessageDialog(null, "Porcentaje excede el 100%.", "Error", JOptionPane.WARNING_MESSAGE);
				
		    }
		}
	}
}


