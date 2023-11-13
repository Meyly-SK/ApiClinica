package com.proyecto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByCorreo(String correo);
}
