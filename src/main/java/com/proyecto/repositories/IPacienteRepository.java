package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

}
