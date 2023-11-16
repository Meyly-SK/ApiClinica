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

import com.proyecto.model.HistorialClinico;
import com.proyecto.services.HistorialService;

@RestController
@RequestMapping("/historiales")
public class HistorialController {

	@Autowired
	private HistorialService historialService;
	
	@PostMapping
	public HistorialClinico guardarHistorial(@RequestBody HistorialClinico historial) {
		return historialService.guardar_HC(historial);
	}
	
	@PutMapping("/{id}")
	public HistorialClinico actualizarHistorial(@RequestBody HistorialClinico historial, @PathVariable("id") int id) {
		historial.setId(id);
		return historialService.actualizar_HC(historial);
	}
	
	@GetMapping("/{id}")
	public HistorialClinico obtenerHistorialporId(@PathVariable Integer id) {
		return historialService.buscar_HC_ID(id);
	}
	
	@GetMapping("/listar")
	public List<HistorialClinico> listarHistoriales(){
		return historialService.obtenerLista_HC();
	}
	
	@DeleteMapping("/{id}")
	public void eliminarHistorial(@PathVariable Integer id) {
		historialService.eliminar_HC_ID(id);
	}
	
}
