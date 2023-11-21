package com.proyecto.services;

import java.util.List;

import com.proyecto.model.Paciente;

public interface PacienteService {

	public Paciente guardarPaciente(Paciente paciente);

	 public Paciente obtenerPacientePorId(int id);

	 public List<Paciente> obtenerTodosLosPacientes();

	 public void eliminarPaciente(int id);
	 
	 public Paciente actualizarPaciente(Paciente paciente);
}
