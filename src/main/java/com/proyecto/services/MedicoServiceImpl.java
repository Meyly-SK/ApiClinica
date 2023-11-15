package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.model.Medico;
import com.proyecto.repositories.IMedicoRepository;
import com.proyecto.utils.UtilsApi.Role;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
    private IMedicoRepository medicoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public Medico guardarMedico(Medico medico) {
		String claveEncriptada = passwordEncoder.encode(medico.getUsuario().getClave());
		medico.getUsuario().setClave(claveEncriptada);
		medico.getUsuario().setRole(Role.PERSONAL_MEDICO);
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

	@Override
	public Medico actualizarMedico(Medico medico) {
		try {
			String claveEncriptada = passwordEncoder.encode(medico.getUsuario().getClave());
			medico.getUsuario().setClave(claveEncriptada);
			medico.getUsuario().setRole(Role.PERSONAL_MEDICO);
			return medicoRepository.save(medico);
		} catch (Exception e) {
			throw e;
		}
	}
}
