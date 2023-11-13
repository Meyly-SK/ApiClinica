package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.Medico;
import com.proyecto.model.Paciente;
import com.proyecto.services.MedicoService;
import com.proyecto.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	 	@Autowired
	    private PacienteService serviPaciente;

	    @PostMapping
	    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
	        return serviPaciente.guardarPaciente(paciente);
	    }

	    @GetMapping("/{id}")
	    public Paciente obtenerPacientePorId(@PathVariable Long id) {
	        return serviPaciente.obtenerPacientePorId(id);
	    }

	    @GetMapping("/listar")
	    public List<Paciente> obtenerTodosLosPaciente() {
	        return serviPaciente.obtenerTodosLosPacientes();
	    }

	    @DeleteMapping("/{id}")
	    public void eliminarPaciente(@PathVariable Long id) {
	        serviPaciente.eliminarPaciente(id);
	    }
}
