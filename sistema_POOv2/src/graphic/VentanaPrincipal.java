package graphic;

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
import java.util.ArrayList;
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
	
	JComboBox comboBox;
	
	public VentanaPrincipal(Vector<Habitat> habitatsVector) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 373);
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
		
		JLabel lblNewLabel_2 = new JLabel("(Acciones disponibles es habitats existentes.)");
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
					AccionesHabitat frame = new AccionesHabitat(habitatSeleccionado);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setBounds(310, 80, 89, 23);
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
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(10, 146, 575, 177);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
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
	}
}
