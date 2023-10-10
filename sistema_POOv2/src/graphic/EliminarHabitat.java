package graphic;

import java.io.FileReader;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Habitat;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class EliminarHabitat extends JFrame {

	private JPanel contentPane;

	public EliminarHabitat(Habitat habitatEntrante, Vector<Habitat> habitatsVector) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 125);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle(habitatEntrante.getName());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Desea Eliminar este Habitat?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 298, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Habitat tmp : habitatsVector) {
					if (tmp.getName().equals(habitatEntrante.getName())) {
						System.out.println("Se ha borrado: " + habitatEntrante.getName());
						habitatsVector.remove(tmp);
						break;
					}
				}
				
				// Ruta al archivo JSON
		        String archivoJSON = "C:\\Users\\Hellish\\Desktop\\SistemaPOO_v2\\sistema_POOv2\\src\\datos\\admin.json";

		        // Hábitat a eliminar
		        String habitatEliminar = habitatEntrante.getName();
		        
		        try {
		            // Parsea el archivo JSON
		            JSONParser parser = new JSONParser();
		            Object obj = parser.parse(new FileReader(archivoJSON));
		            JSONObject jsonObject = (JSONObject) obj;

		            // Obtiene la matriz de hábitats
		            JSONArray habitats = (JSONArray) jsonObject.get("hábitats");

		            // Itera a través de los hábitats y elimina el deseado
		            for (int i = 0; i < habitats.size(); i++) {
		                String habitat = (String) habitats.get(i);
		                if (habitat.equals(habitatEliminar)) {
		                    habitats.remove(i);
		                    break; // Termina el bucle cuando se encuentra y elimina el hábitat
		                }
		            }

		            // Guarda el objeto JSON actualizado en el archivo
		            try (FileWriter fileWriter = new FileWriter(archivoJSON)) {
		                fileWriter.write(jsonObject.toJSONString());
		                System.out.println("Hábitat '" + habitatEliminar + "' eliminado con éxito.");
		            } catch (IOException e1) {
		                System.err.println("Error al guardar el archivo JSON: " + e1.getMessage());
		            }
		        } catch (IOException | ParseException e1) {
		            System.err.println("Error al leer o parsear el archivo JSON: " + e1.getMessage());
		        }
		        
				cerrar();
				
			}
		});
		btnNewButton.setBackground(new Color(240, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 49, 144, 32);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setBounds(164, 49, 144, 32);
		contentPane.add(btnCancelar);
	}
	
	private void cerrar() {
		this.dispose();
	}
}
