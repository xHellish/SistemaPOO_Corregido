package sistema;

public class Especie {
	
	String nombre;
	int porcentaje;
	
	public Especie (String nombre, int porcentaje){
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}
	
	public String getName() {
		return nombre;
	}
	
	public int getPorcent() {
		return porcentaje;
	}
	
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	

}
