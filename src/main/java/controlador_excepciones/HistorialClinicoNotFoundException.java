package controlador_excepciones;

public class HistorialClinicoNotFoundException extends RuntimeException{

	private static long serialVersionUID = 1L;
	
	public HistorialClinicoNotFoundException(Integer id) {
		super("No se encontro un historial clinico con ID " + id);
	}
}
