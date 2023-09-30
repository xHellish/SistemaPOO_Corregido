package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sistema.Habitat;

public class AccionesHabitat extends JFrame {

	public AccionesHabitat(Habitat habitatEntrante) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(habitatEntrante.getName());
		

	}

}
