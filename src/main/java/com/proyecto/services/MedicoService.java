package com.proyecto.services;

import java.util.List;

import com.proyecto.model.Medico;

public interface MedicoService {
	 public Medico guardarMedico(Medico medico);

	 public Medico obtenerMedicoPorId(int id);

	 public List<Medico> obtenerTodosLosMedicos();

	 public void eliminarMedico(int id);
}
