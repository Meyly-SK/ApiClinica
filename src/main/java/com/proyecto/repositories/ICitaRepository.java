package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Cita;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Long>{

}
