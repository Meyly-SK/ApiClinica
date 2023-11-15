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

import com.proyecto.model.Medico;
import com.proyecto.services.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico guardarMedico(@RequestBody Medico medico) {
        return medicoService.guardarMedico(medico);
    }

    @GetMapping("/{id}")
    public Medico obtenerMedicoPorId(@PathVariable int id) {
        return medicoService.obtenerMedicoPorId(id);
    }

    @GetMapping("/listar")
    public List<Medico> obtenerTodosLosMedicos() {
        return medicoService.obtenerTodosLosMedicos();
    }
    
    @PutMapping("/{id}")
    public Medico actualizarMedico(@RequestBody Medico medico, @PathVariable("id") int id) {
        medico.setId(id);
        medico.getUsuario().setId(obtenerMedicoPorId(id).getUsuario().getId());
    	return medicoService.actualizarMedico(medico);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable int id) {
        medicoService.eliminarMedico(id);
    }
}
