package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Historial_Clinico;

public interface Historial_Clinico_Service {

	public Historial_Clinico guardar_HC(Historial_Clinico historialClinico);
    public Historial_Clinico buscar_HC_ID(Integer id);
    public Historial_Clinico actualizar_HC(Historial_Clinico historialClinico);
    public List<Historial_Clinico> obtenerLista_HC();
    void eliminar_HC_ID(Integer id);
}
