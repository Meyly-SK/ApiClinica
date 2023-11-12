package com.proyecto.controlador_excepciones;

public class HistorialClinicoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HistorialClinicoNotFoundException(Integer id) {
        super("No se encontró un historial clínico con ID " + id);
    }
	
}
