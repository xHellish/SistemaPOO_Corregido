package graphic;

import sistema.Especie;
import sistema.Habitat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.Vector;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;

public class VentanaPrincipalView extends JFrame {

	private JPanel contentPane;
    private JPanel panel;
    private JComboBox<String> comboBox;
    
    private JLabel tituloLabel;
    private JLabel habitatLabel;
    private JLabel subAvisoLabel;
    
    private JButton accionesButton;
    private JButton actualizarButton;
    private JButton agregarHabitatButton;
	
	public VentanaPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel.
		panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(10, 146, 615, 225);
		contentPane.add(panel);
				
		// ------------------ Labels ------------------ //
		tituloLabel = new JLabel("Sistema de Administración de Refugio.");
		tituloLabel.setForeground(new Color(224, 255, 255));
		tituloLabel.setBackground(new Color(0, 0, 0));
		tituloLabel.setBounds(10, 11, 389, 27);
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(tituloLabel);
		
		subAvisoLabel = new JLabel("(Acciones disponibles en habitats existentes.)");
		subAvisoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		subAvisoLabel.setForeground(new Color(248, 248, 255));
		subAvisoLabel.setBounds(117, 117, 274, 14);
		contentPane.add(subAvisoLabel);
		
		habitatLabel = new JLabel("Habitat:");
		habitatLabel.setForeground(new Color(248, 248, 255));
		habitatLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		habitatLabel.setBounds(10, 74, 87, 27);
		contentPane.add(habitatLabel);
		
		// ---------------- Buttons ---------------- //
		accionesButton = new JButton("Acciones");
		accionesButton.setBackground(new Color(255, 182, 193));
		accionesButton.setBounds(310, 80, 114, 23);
		contentPane.add(accionesButton);
		
		actualizarButton = new JButton("Actualizar");
		actualizarButton.setBackground(new Color(152, 251, 152));
		actualizarButton.setBounds(434, 80, 117, 23);
		contentPane.add(actualizarButton);
		
		agregarHabitatButton = new JButton("+");
		agregarHabitatButton.setBackground(new Color(0, 206, 209));
		agregarHabitatButton.setBounds(559, 75, 45, 32);
		contentPane.add(agregarHabitatButton);
				
		// Combobox de los habitats.
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBackground(new Color(0, 139, 139));
		comboBox.setBounds(107, 74, 193, 31);
		contentPane.add(comboBox);
		
	}
	
	public JButton getAccionesButton() {
		return accionesButton;
	}
	
	public JButton getActualizarButton() {
		return actualizarButton;
	}
	
	public JButton getAgregarHabitatButton() {
		return agregarHabitatButton;
	}
	
	public String getComboboxTxt() {
		return (String) comboBox.getSelectedItem();
	}
	
	public void construirVentana(Vector<Habitat> habitats) {
		
	    comboBox.removeAllItems();
	    
	    for (Habitat habitat : habitats) {
	        if (!habitat.getName().isEmpty()) {
	            comboBox.addItem(habitat.getName());
	        }
	    }
	    panel.removeAll();
	    panel.setLayout(new GridLayout(1, habitats.size()));
	    
	    for (Habitat habitat : habitats) {
	        if (!habitat.getName().isEmpty()) {
	            JPanel habitatPanel = new JPanel();
	            
	            int size;
	            if (habitat.getVectorEspecies() == null) {
	            	size = 0;	
	            }else {
	            	size = habitat.getVectorEspecies().size();
	            }
	            
	            habitatPanel.setLayout(new GridLayout(size + 1, 1)); // Una fila por hábitat y una fila por cada especie

	            JLabel habitatLabel = new JLabel(habitat.getName());
	            habitatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	            habitatLabel.setForeground(Color.white);
	            habitatLabel.setHorizontalAlignment(SwingConstants.CENTER);
	            habitatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            habitatPanel.setBackground(new Color(0x0B5345));
	            habitatPanel.add(habitatLabel);
	            
	            for (Especie especieTmp : habitat.getVectorEspecies()) {
	                if (!especieTmp.getName().isEmpty()) {
	                    JLabel especieLabel = new JLabel("- " + especieTmp.getName() + " " + especieTmp.getPorcent() + "%");
	                    especieLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	                    especieLabel.setForeground(Color.white);
	                    habitatPanel.add(especieLabel);
	                }
	            }
	            panel.add(habitatPanel);
	        }
	    }
	    getContentPane().revalidate();
	    getContentPane().repaint();
	}
}
