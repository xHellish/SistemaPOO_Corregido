package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import sistema.Habitat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AgregarHabitat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Vector<Habitat> _habitats;
	
	public AgregarHabitat(Vector<Habitat> habitats) {
		
		_habitats = habitats;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 135);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Agregar Habitat");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Aceptar
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
				
			}
		});
		btnNewButton.setBackground(new Color(64, 224, 208));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(34, 59, 114, 27);
		contentPane.add(btnNewButton);
		
		// Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 182, 193));
		btnCancelar.setBounds(169, 59, 114, 27);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 74, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 19, 189, 27);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	private void aceptar() {
		
		String habitatNombre = textField.getText(); 
		boolean existe = false;
		boolean vacio = false;
		
		if (habitatNombre.equals("")) {
			vacio = true;
			JOptionPane.showMessageDialog(null, "Nombre vacío", "Error", JOptionPane.WARNING_MESSAGE);
		} else {
			for (Habitat tmp : _habitats) {
				if (tmp.getName().equals(habitatNombre)) {
					JOptionPane.showMessageDialog(null, "Habitat ya existe", "Error", JOptionPane.WARNING_MESSAGE);
					existe = true;
				}
			}
		}
		
		if (!existe && !vacio) {
			_habitats.add(new Habitat(habitatNombre));
			System.out.println("Se ha añadido nuevo habitat");
			
			try {
		        // Paso 1: Leer el JSON existente
		        ObjectMapper objectMapper = new ObjectMapper();
		        File archivoJson = new File("C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json");
		        JsonNode rootNode = objectMapper.readTree(archivoJson);

		        // Paso 2: Agregar el nuevo hábitat al arreglo de hábitats
		        if (rootNode.has("hábitats") && rootNode.get("hábitats").isArray()) {
		            ArrayNode habitatsArray = (ArrayNode) rootNode.get("hábitats");
		            habitatsArray.add(textField.getText());
		        } else {
		            // Si no existe la clave "hábitats" o no es un arreglo, crea uno nuevo
		            ArrayNode newHabitatsArray = objectMapper.createArrayNode();
		            newHabitatsArray.add(textField.getText());
		            ((ObjectNode) rootNode).set("hábitats", newHabitatsArray);
		        }

		        // Paso 3: Escribir la estructura actualizada de vuelta al archivo JSON
		        objectMapper.writeValue(archivoJson, rootNode);

		        System.out.println("Nuevo hábitat agregado exitosamente.");

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			
			this.dispose();
		}
	}
	
	private void cancelar() {
		this.dispose();
	}
}
