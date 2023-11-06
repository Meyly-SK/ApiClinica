package com.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.model.AuthResponse;
import com.proyecto.model.LoginRequest;
import com.proyecto.model.Paciente;
import com.proyecto.model.RegisterRequest;
import com.proyecto.model.Usuario;
import com.proyecto.repositories.IPacienteRepository;
import com.proyecto.repositories.IUsuarioRepository;
import com.proyecto.utils.UtilsApi.Role;

@Service
public class AuthService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getClave()));
		UserDetails usuarioDetails = usuarioRepository.findByCorreo(request.getCorreo()).orElseThrow();
		String token = jwtService.getToken(usuarioDetails);
		return AuthResponse.builder().token(token).build();
	}

	public AuthResponse register(RegisterRequest request) {
		Usuario nuevoUsuario = Usuario.builder()
				.nombre(request.getNombre())
				.apellido(request.getApellido())
				.fechaNacimiento(request.getFechaNacimiento())
				.sexo(request.getSexo())
				.dni(request.getDni())
				.correo(request.getCorreo())
				.clave(passwordEncoder.encode(request.getClave()))
				.role(Role.PACIENTE)
				.build();
		Paciente nuevoPaciente = Paciente.builder()
				.usuario(nuevoUsuario)
				.build();
		pacienteRepository.save(nuevoPaciente);
		
		return AuthResponse.builder().token(jwtService.getToken(nuevoUsuario)).build();
	}

}
