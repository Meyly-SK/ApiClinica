package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Medico;

public interface IMedicoRepository extends JpaRepository<Medico, Integer>{

}
