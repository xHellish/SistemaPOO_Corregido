package graphic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import sistema.Especie;
import sistema.Habitat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exeptions.ExeptionBenFarz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.awt.event.InputMethodEvent;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	JComboBox comboBox;
	Vector<Habitat> _habitatsVector;
	
	public VentanaPrincipal(Vector<Habitat> habitatsVector) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ------------------ Labels ------------------ //
		JLabel lblNewLabel = new JLabel("Sistema de Administración de Refugio.");
		lblNewLabel.setForeground(new Color(224, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 11, 389, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("(Acciones disponibles en habitats existentes.)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_2.setBounds(117, 117, 274, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Habitat:");
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 74, 87, 27);
		contentPane.add(lblNewLabel_1);
		
		// ---------------- Buttons ---------------- //
		JButton btnNewButton = new JButton("Acciones");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws ExeptionBenFarz {
				String habitatSeleccionadoStr = (String) comboBox.getSelectedItem();
				Habitat habitatSeleccionado = null;
				
				for (Habitat tmp : habitatsVector) {
					if (tmp.getName() == habitatSeleccionadoStr && tmp.getName() == "") {
						throw new ExeptionBenFarz("Nombre de Habitat vacío.");
						
					}else if (tmp.getName() == habitatSeleccionadoStr) {
						habitatSeleccionado = tmp;
					}
				}
				
				try {
					AccionesHabitat frame = new AccionesHabitat(habitatSeleccionado, habitatsVector);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setBounds(310, 80, 114, 23);
		contentPane.add(btnNewButton);
				
		// Combobox de los habitats.
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBackground(new Color(0, 139, 139));
		comboBox.setBounds(107, 74, 193, 31);
		contentPane.add(comboBox);
		
		for (int i = 0; i < habitatsVector.size(); i++) {
			comboBox.addItem(habitatsVector.elementAt(i).getName());
		}
		
		// Panel.
		panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(10, 146, 615, 225);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar(habitatsVector);
			}
		});
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.setBounds(434, 80, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabitat agregarHabitat = new AgregarHabitat(habitatsVector);
				agregarHabitat.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 206, 209));
		btnNewButton_2.setBounds(559, 75, 45, 32);
		contentPane.add(btnNewButton_2);
		
		ArrayList<JLabel> labels = new ArrayList<>();
		
		// Agrega labels al JPanel
		for (int i = 0; i < habitatsVector.size(); i++) {
		    if (!habitatsVector.elementAt(i).getName().isEmpty()) {
		        JLabel label = new JLabel("<html>" + habitatsVector.elementAt(i).getName() + "<br>");
		        label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        label.setForeground(Color.WHITE);
		        label.setHorizontalAlignment(SwingConstants.CENTER);
		        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		        for (Especie especieTmp : habitatsVector.elementAt(i).getVectorEspecies()) {
		            label.setText(label.getText() + "-" + especieTmp.getName() + " " + especieTmp.getPorcent() + "%" + "<br>");
		        }

		        label.setText(label.getText() + "</html>");

		        panel.add(label);
		    }
		}
		
		_habitatsVector = habitatsVector;
	}
	
	// Actualizar ventana main.
	public void actualizar(Vector<Habitat> habitatsVector) {
	    // Limpiar el JComboBox actual
	    comboBox.removeAllItems();

	    // Agregar los nuevos elementos al JComboBox
	    for (Habitat habitat : habitatsVector) {
	        comboBox.addItem(habitat.getName());
	    }

	    // Limpiar el contenido actual del panel
	    panel.removeAll();

	    // Actualizar el contenido del panel con las etiquetas actualizadas
	    for (Habitat habitat : habitatsVector) {
	        if (!habitat.getName().isEmpty()) {
	            JLabel label = new JLabel("<html>" + habitat.getName() + "<br>");
	            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	            label.setForeground(Color.WHITE);
	            label.setHorizontalAlignment(SwingConstants.CENTER);
	            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	            for (Especie especieTmp : habitat.getVectorEspecies()) {
	                label.setText(label.getText() + "-" + especieTmp.getName() + " " + especieTmp.getPorcent() + "%" + "<br>");
	            }

	            label.setText(label.getText() + "</html>");

	            panel.add(label);
	        }
	    }

	    // Actualizar la ventana
	    getContentPane().revalidate();
	    getContentPane().repaint();
	    
	    
	}
}
