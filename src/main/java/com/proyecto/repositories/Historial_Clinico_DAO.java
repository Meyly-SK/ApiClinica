package com.proyecto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Historial_Clinico;

@Repository
public interface Historial_Clinico_DAO extends CrudRepository<Historial_Clinico, Integer> {

	public List<Historial_Clinico> findAll();
	
}
