package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Paciente;
import com.proyecto.repositories.IPacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private IPacienteRepository pacienteRepo;

	@Override
	public Paciente guardarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepo.save(paciente);
	}

	@Override
	public Paciente obtenerPacientePorId(int id) {
		// TODO Auto-generated method stub
		return pacienteRepo.findById(id).orElse(null);
	}

	@Override
	public List<Paciente> obtenerTodosLosPacientes() {
		// TODO Auto-generated method stub
		return pacienteRepo.findAll();
	}

	@Override
	public void eliminarPaciente(int id) {
		// TODO Auto-generated method stub
		pacienteRepo.deleteById(id);
		
	}
}
