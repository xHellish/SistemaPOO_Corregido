package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sistema.Habitat;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class AccionesHabitat extends JFrame {

	public AccionesHabitat(Habitat habitatEntrante) {
		getContentPane().setBackground(new Color(0, 128, 128));
		setBounds(100, 100, 450, 214);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(habitatEntrante.getName());
		getContentPane().setLayout(null);
		
		// ---------- Buttons ---------- //
		JButton btnNewButton = new JButton("Agregar Especie");
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 11, 414, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar Especie");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(240, 128, 128));
		btnNewButton_1.setBounds(10, 74, 414, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Eliminar Hábitat");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(240, 128, 128));
		btnNewButton_3.setBounds(10, 125, 414, 40);
		getContentPane().add(btnNewButton_3);
		
		
	}
}
