package graphic;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class EliminarEspecieView extends JFrame {
	private JTextField textField;
	private JButton borrarEspecieButton;
	
	public EliminarEspecieView() {
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
		
		borrarEspecieButton = new JButton("Borrar Especie");
		borrarEspecieButton.setBackground(new Color(255, 182, 193));
		borrarEspecieButton.setBounds(20, 54, 287, 29);
		getContentPane().add(borrarEspecieButton);

	}
	
	public JButton getBorrarEspecieButton() {
		return borrarEspecieButton;
	}
	
	public String getTexField() {
		return textField.getText();
	}
	
}
