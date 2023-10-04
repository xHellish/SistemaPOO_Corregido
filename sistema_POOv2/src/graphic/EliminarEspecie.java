package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sistema.Habitat;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarEspecie extends JFrame {
	private JTextField textField;

	public EliminarEspecie(Habitat habitatEntrante) {
		getContentPane().setBackground(new Color(255, 192, 203));
		setBounds(100, 100, 343, 132);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 83, 29);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(84, 14, 223, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Borrar Especie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String especieEscrita = textField.getText();
				if (habitatEntrante.deleteEspecie(especieEscrita)) {
					cerrar();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setBounds(20, 54, 287, 29);
		getContentPane().add(btnNewButton);

	}
	
	private void cerrar() {
		this.dispose();
	}
	
}
