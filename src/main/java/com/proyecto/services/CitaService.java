package com.proyecto.services;

import java.util.List;


import com.proyecto.model.Cita;

public interface CitaService {

	public Cita guardarCita(Cita cita);
	public Cita buscarCitaporId(Long id);
	public List<Cita> ListarCitas();
	public void eliminarCita(Long id);
}
