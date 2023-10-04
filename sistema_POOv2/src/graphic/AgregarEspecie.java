package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Especie;
import sistema.Habitat;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEspecie extends JFrame {
    private Especie especieAgregada;
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public AgregarEspecie(Habitat habitatEntrante) {
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

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField.setBounds(100, 15, 191, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        // Etiqueta y campo de texto para el porcentaje
        JLabel lblPorcentaje = new JLabel("Porcentaje:");
        lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPorcentaje.setBounds(10, 56, 116, 34);
        contentPane.add(lblPorcentaje);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField_1.setColumns(10);
        textField_1.setBounds(118, 61, 53, 29);
        contentPane.add(textField_1);

        JLabel lblNewLabel_1 = new JLabel("(limítese a escribir un número)");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(181, 69, 208, 14);
        contentPane.add(lblNewLabel_1);

        // Botón para aceptar
        JButton btnNewButton = new JButton("Agregar Especie");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else if (textField_1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Porcentaje no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    String nombre = textField.getText();
                    int porcentaje = Integer.parseInt(textField_1.getText());
                    
                    // Crear una instancia de Especie con los datos ingresados
                    especieAgregada = new Especie(nombre, porcentaje);
                    
                    habitatEntrante.addEspecie(especieAgregada);
                    
                    cerrar();
                    
                    
                    
                    // Hacer algo con la instancia de especieAgregada si es necesario
                    // Por ejemplo, imprimir sus valores
                    System.out.println("Nombre: " + especieAgregada.getName());
                    System.out.println("Porcentaje: " + especieAgregada.getPorcent());
                }
            }
        });
        btnNewButton.setBackground(new Color(224, 255, 255));
        btnNewButton.setBounds(10, 101, 365, 36);
        contentPane.add(btnNewButton);
    }
    
    public void cerrar () {
    	this.dispose();
    }
}