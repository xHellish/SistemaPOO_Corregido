package graphic;

import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sistema.Habitat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EliminarHabitatView extends JFrame {

	private JPanel contentPane;
	private JButton aceptarButton;
	private JButton btnCancelar;
	
	public EliminarHabitatView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 125);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Desea Eliminar este Habitat?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 298, 32);
		contentPane.add(lblNewLabel);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setBackground(new Color(240, 128, 128));
		aceptarButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		aceptarButton.setBounds(10, 49, 144, 32);
		contentPane.add(aceptarButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setBounds(164, 49, 144, 32);
		contentPane.add(btnCancelar);
	}
	
	public JButton getAceptarButton() {
		return aceptarButton;
	}
	
	public JButton getCancelarButton() {
		return btnCancelar;
	}
	
	public void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}
}
