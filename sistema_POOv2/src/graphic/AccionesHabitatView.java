package graphic;

import javax.swing.JFrame;

import sistema.Habitat;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AccionesHabitatView extends JFrame {
	
	private JButton agregarEspecieButton;
	private JButton eliminarEspecieButton;
	private JButton eliminarHabitatButton;
	private String nombreHabitat;
	
	public AccionesHabitatView() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setBounds(100, 100, 450, 214);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(nombreHabitat);
		getContentPane().setLayout(null);
		
		// ---------- Buttons ---------- //
		agregarEspecieButton = new JButton("Agregar Especie");
		agregarEspecieButton.setBackground(new Color(102, 205, 170));
		agregarEspecieButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agregarEspecieButton.setBounds(10, 11, 414, 52);
		getContentPane().add(agregarEspecieButton);
		
		eliminarEspecieButton = new JButton("Eliminar Especie");	
		eliminarEspecieButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminarEspecieButton.setBackground(new Color(240, 128, 128));
		eliminarEspecieButton.setBounds(10, 74, 414, 40);
		getContentPane().add(eliminarEspecieButton);
		
		eliminarHabitatButton = new JButton("Eliminar Hábitat");
		eliminarHabitatButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminarHabitatButton.setBackground(new Color(240, 128, 128));
		eliminarHabitatButton.setBounds(10, 125, 414, 40);
		getContentPane().add(eliminarHabitatButton);
		
	}
	
	public JButton getAgregarEspecieButton() {
		return agregarEspecieButton;
	}
	
	public JButton getEliminarEspecieButton() {
		return eliminarEspecieButton;
	}
	
	public JButton getEliminarHabitatButton() {
		return eliminarHabitatButton;
	}
	
	public void setNombre(String nombreHabitat) {
		this.nombreHabitat = nombreHabitat;
		this.setTitle(nombreHabitat);
	}
}
