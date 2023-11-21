package com.proyecto.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Cita;

@Repository
public interface CitaService {

	public Cita guardarCita(Cita cita);
	public Cita buscarCitaporId(Long id);
	public List<Cita> ListarCitas();
	public void eliminarCita(Long id);
	public Cita actualizarCita(Cita cita);
}
