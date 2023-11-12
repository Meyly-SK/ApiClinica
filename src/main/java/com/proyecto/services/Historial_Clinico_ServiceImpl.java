package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.controlador_excepciones.HistorialClinicoNotFoundException;
import com.proyecto.models.Historial_Clinico;
import com.proyecto.repositories.Historial_Clinico_DAO;

@Service
public class Historial_Clinico_ServiceImpl implements Historial_Clinico_Service{
	
	@Autowired
	private Historial_Clinico_DAO historialRepository;

	@Override
	public Historial_Clinico guardar_HC(Historial_Clinico historialClinico) {
		
		//return this.historialRepository.save(historialClinico);
		
		if (historialClinico == null) {
	        throw new IllegalArgumentException("El historial clínico no puede ser nulo");
	    }

	    return this.historialRepository.save(historialClinico);
		
	}

	@Override
	public Historial_Clinico buscar_HC_ID(Integer id) {
		
		Optional<Historial_Clinico> historial = this.historialRepository.findById(id);
		if(historial.isPresent()) {
			return historial.get();
		}else {
	        throw new HistorialClinicoNotFoundException(id);
	    }
		
	}

	@Override
	public Historial_Clinico actualizar_HC(Historial_Clinico historialClinico) {

		//return this.historialRepository.save(historialClinico);
		
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
	public List<Historial_Clinico> obtenerLista_HC() {
		return this.historialRepository.findAll();
	}
	
}