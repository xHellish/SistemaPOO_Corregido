package graphic.models;

import sistema.Especie;
import sistema.Habitat;

public class AgregarEspecieModel {
	
	private Habitat habitat;
	
	public AgregarEspecieModel(Habitat habitat) {
		this.habitat = habitat;
		
	}
	
	public void agregarEspecie(Especie nuevaEspecie) {
		habitat.addEspecie(nuevaEspecie);
	}
	
	public Habitat getHabitat() {
		return habitat;
	}

}
