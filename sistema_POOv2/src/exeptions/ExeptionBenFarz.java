package exeptions;

public class ExeptionBenFarz extends RuntimeException  {
	
	public ExeptionBenFarz() {
        super("Ha ocurrido un error.");
    }
	
	public ExeptionBenFarz(String mensajeErr) {
        super(mensajeErr);
    }

}
