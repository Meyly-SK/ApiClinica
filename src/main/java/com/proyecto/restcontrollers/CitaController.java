package com.proyecto.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.Cita;
import com.proyecto.services.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;
	
	@PostMapping
	public Cita guardarCita(@RequestBody Cita cita) {
		return citaService.guardarCita(cita);
	}
	
	@GetMapping("/{id}")
	public Cita obtenerCitaporId(@PathVariable Long id) {
		return citaService.buscarCitaporId(id);
	}
	
	@GetMapping("/listar")
	public List<Cita> listarCitas(){
		return citaService.ListarCitas();
	}
	
	@DeleteMapping("/{id}")
	public void eliminarCita(@PathVariable Long id) {
		citaService.eliminarCita(id);
	}
	
	@PutMapping(value="/{id}")
	public Cita actualizarCita(@RequestBody Cita cita, @PathVariable("id") Long id){
		cita.setCita_id(id);
		return citaService.actualizarCita(cita);
	} 
}
