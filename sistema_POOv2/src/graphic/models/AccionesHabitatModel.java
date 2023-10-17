package graphic.models;

import java.util.Vector;

import sistema.Habitat;

public class AccionesHabitatModel {
	
	String nombreHabitat;
	Habitat habitat;
	Vector<Habitat> habitats;
	
	public AccionesHabitatModel (Vector<Habitat> habitats, Habitat habitat){
		this.habitat = habitat;
		this.habitats = habitats;
	}
	
	public String getName() {
		return nombreHabitat;
	}
	
	public Habitat getHabitat() {
		return habitat;
	}
	
	public Vector<Habitat> getHabitatVector(){
		return habitats;
	}

}
