package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public VentanaPrincipal() {
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
		lblNewLabel_2.setBounds(107, 117, 274, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Habitat:");
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 74, 87, 27);
		contentPane.add(lblNewLabel_1);
		
		// ---------------- Buttons ---------------- //
				JButton btnNewButton = new JButton("Acciones");
				btnNewButton.setBackground(new Color(255, 182, 193));
				btnNewButton.setBounds(292, 80, 89, 23);
				contentPane.add(btnNewButton);
				
		// Combobox de los habitats.
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(107, 78, 175, 27);
		contentPane.add(comboBox);
		
		
		
		
		
		
	}
}
