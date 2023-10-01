package sistema;

public class Especie {
	
	String nombre;
	int porcentaje;
	
	Especie (String nombre, int porcentaje){
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}
	
	public String getName() {
		return nombre;
	}
	
	public int getPorcent() {
		return porcentaje;
	}
	

}
