package com.proyecto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.model.HistorialClinico;

@Repository
public interface IHistorialClinico extends CrudRepository<HistorialClinico, Integer>{

	public List<HistorialClinico> findAll();
}
