package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}