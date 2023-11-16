package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Medico;
import com.proyecto.repositories.IMedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
    private IMedicoRepository medicoRepository;
	
	@Override
    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public void eliminarMedico(int id) {
        medicoRepository.deleteById(id);
    }
}
