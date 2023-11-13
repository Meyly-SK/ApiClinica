package com.proyecto.services;

import java.util.List;

import com.proyecto.model.Paciente;

public interface PacienteService {

	 public Paciente guardarPaciente(Paciente paciente);

	 public Paciente obtenerPacientePorId(Long id);

	 public List<Paciente> obtenerTodosLosPacientes();

	 public void eliminarPaciente(Long id);
}
