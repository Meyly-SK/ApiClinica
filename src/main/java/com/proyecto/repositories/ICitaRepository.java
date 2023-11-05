package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Long>{

}
