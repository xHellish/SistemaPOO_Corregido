package graphic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class AgregarEspecieView extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldPorcentaje;
    private JButton agregarEspecieButton;
    
    
    public AgregarEspecieView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 397, 188);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(127, 255, 212));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta y campo de texto para el nombre
        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 80, 34);
        contentPane.add(lblNewLabel);

        textFieldNombre = new JTextField();
        textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textFieldNombre.setBounds(100, 15, 191, 30);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        // Etiqueta y campo de texto para el porcentaje
        JLabel lblPorcentaje = new JLabel("Porcentaje:");
        lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPorcentaje.setBounds(10, 56, 116, 34);
        contentPane.add(lblPorcentaje);

        textFieldPorcentaje = new JTextField();
        textFieldPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textFieldPorcentaje.setColumns(10);
        textFieldPorcentaje.setBounds(118, 61, 53, 29);
        contentPane.add(textFieldPorcentaje);

        JLabel lblNewLabel_1 = new JLabel("(limítese a escribir un número)");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(181, 69, 208, 14);
        contentPane.add(lblNewLabel_1);

        // Botón para aceptar
        agregarEspecieButton = new JButton("Agregar Especie");
        agregarEspecieButton.setBackground(new Color(224, 255, 255));
        agregarEspecieButton.setBounds(10, 101, 365, 36);
        contentPane.add(agregarEspecieButton);
    }
    
    public JButton getAceptarButton() {
    	return agregarEspecieButton;
    }
    
    public String getTextFieldNombre() {
    	return textFieldNombre.getText();
    }
    
    public String getTextFieldPorcentaje() {
    	return textFieldPorcentaje.getText();
    }
    
    public void cerrar () {
    	this.dispose();
    }
}