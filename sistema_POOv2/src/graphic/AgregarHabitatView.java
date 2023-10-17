package graphic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AgregarHabitatView extends JFrame {
	
	JButton btnCancelar;
	JButton btnAceptar;
	private JPanel contentPane;
	private JTextField textField;
	
	public AgregarHabitatView() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 135);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Agregar Habitat");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Aceptar
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(64, 224, 208));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAceptar.setBounds(34, 59, 114, 27);
		contentPane.add(btnAceptar);
		
		// Cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 182, 193));
		btnCancelar.setBounds(169, 59, 114, 27);
		contentPane.add(btnCancelar);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreLabel.setBounds(10, 11, 74, 37);
		contentPane.add(nombreLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 19, 189, 27);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public JButton getBotonAceptar() {
		return btnAceptar;
	}
	
	public JButton getBotonCancelar() {
		return btnCancelar;
	}
	
	public String getTextField() {
		return textField.getText();
	}
	
	public void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}
}
