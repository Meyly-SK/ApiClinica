package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.model.Historial_Clinico;
import com.proyecto.services.Historial_Clinico_ServiceImpl;

@Controller
@RequestMapping("/historial")
public class HistorialController {

    private final Historial_Clinico_ServiceImpl historialClinicoService;

    @Autowired
    public HistorialController(Historial_Clinico_ServiceImpl historialClinicoService) {
        this.historialClinicoService = historialClinicoService;
    }

    @GetMapping("/listar")
    public String listarHistoriales(Model model) {
        List<Historial_Clinico> historiales = historialClinicoService.obtenerLista_HC();
        model.addAttribute("historiales", historiales);
        return "historial/listar"; // Esto asume que tienes una vista llamada "listar.html"
    }

    @GetMapping("/ver/{id}")
    public String verHistorial(@PathVariable Integer id, Model model) {
        Historial_Clinico historial = historialClinicoService.buscar_HC_ID(id);
        model.addAttribute("historial", historial);
        return "historial/ver"; // Esto asume que tienes una vista llamada "ver.html"
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("historial", new Historial_Clinico());
        return "historial/crear"; // Esto asume que tienes una vista llamada "crear.html" para el formulario de creación
    }

    @PostMapping("/guardar")
    public String guardarHistorial(@ModelAttribute Historial_Clinico historial, Model model) {
        historialClinicoService.guardar_HC(historial);
        return "redirect:/historial/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Historial_Clinico historial = historialClinicoService.buscar_HC_ID(id);
        model.addAttribute("historial", historial);
        return "historial/editar"; // Esto asume que tienes una vista llamada "editar.html" para el formulario de edición
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarHistorial(@PathVariable Integer id, @ModelAttribute Historial_Clinico historial) {
        historial.setId(id); // Asegúrate de establecer el ID correcto para la actualización
        historialClinicoService.actualizar_HC(historial);
        return "redirect:/historial/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHistorial(@PathVariable Integer id) {
        historialClinicoService.eliminar_HC_ID(id);
        return "redirect:/historial/listar";
    }
}