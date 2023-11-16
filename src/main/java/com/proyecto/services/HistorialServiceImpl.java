package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.HistorialClinico;
import com.proyecto.repositories.IHistorialClinico;

import controlador_excepciones.HistorialClinicoNotFoundException;

@Service
public class HistorialServiceImpl implements HistorialService{

	@Autowired
	private IHistorialClinico historialRepository;

	@Override
	public HistorialClinico guardar_HC(HistorialClinico historialClinico) {

		if (historialClinico == null) {
	        throw new IllegalArgumentException("El historial clínico no puede ser nulo");
	    }

	    return this.historialRepository.save(historialClinico);

	}

	@Override
	public HistorialClinico buscar_HC_ID(Integer id) {

		Optional<HistorialClinico> historial = this.historialRepository.findById(id);
		if(historial.isPresent()) {
			return historial.get();
		}else {
	        throw new HistorialClinicoNotFoundException(id);
	    }

	}

	@Override
	public HistorialClinico actualizar_HC(HistorialClinico historialClinico) {

		if (historialClinico == null) {
	        throw new IllegalArgumentException("El historial clínico no puede ser nulo");
	    }else{
			Integer id = historialClinico.getId();

		    if (this.historialRepository.existsById(id)) {
		        return this.historialRepository.save(historialClinico);
		    } else {
		        throw new HistorialClinicoNotFoundException(id);
		    }
	    }
	}

	@Override
	public void eliminar_HC_ID(Integer id) {

		this.historialRepository.deleteById(id);

	}

	@Override
	public List<HistorialClinico> obtenerLista_HC() {
		return this.historialRepository.findAll();
	}
}
