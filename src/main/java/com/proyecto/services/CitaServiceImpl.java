package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Cita;
import com.proyecto.repositories.ICitaRepository;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	private ICitaRepository citarepository;
	
	@Override
	public Cita guardarCita(Cita cita) {
		return citarepository.save(cita);
	}
	
	@Override
	public Cita buscarCitaporId(Long id) {
		return citarepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Cita> ListarCitas() {
		return citarepository.findAll();
	}
	
	@Override
	public void eliminarCita(Long id) {
		citarepository.deleteById(id);
	}

	@Override
	public Cita actualizarCita(Cita cita) {
		// TODO Auto-generated method stub
		try {
			Cita savedCita = this.citarepository.save(cita);
			return savedCita;
		} catch (Exception e) {
			throw e;
		}

	}
}
