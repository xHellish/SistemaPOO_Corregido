package graphic.models;

import sistema.Habitat;

public class EliminarEspecieModel {
	
	Habitat habitat;
	
	public EliminarEspecieModel(Habitat habitat) {
		this.habitat = habitat;
	}
	
	public Habitat getHabitat() {
		return habitat;
	}
	
	public boolean borrarEspecie(String especieToDelete) {
		return habitat.deleteEspecie(especieToDelete);
	}
}
