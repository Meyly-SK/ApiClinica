package com.proyecto.services;

import java.util.List;

import com.proyecto.model.HistorialClinico;

public interface HistorialService {

	public HistorialClinico guardar_HC(HistorialClinico historialClinico);
    public HistorialClinico buscar_HC_ID(Integer id);
    public HistorialClinico actualizar_HC(HistorialClinico historialClinico);
    public List<HistorialClinico> obtenerLista_HC();
    void eliminar_HC_ID(Integer id);
}
