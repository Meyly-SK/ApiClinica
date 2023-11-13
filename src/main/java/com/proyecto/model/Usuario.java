package com.proyecto.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private int  id;
	
	@Column(name = "usuario_nombre")
	private String nombre;
	
	@Column(name = "usuario_apellido")
	private String apellido;
	
	@Column(name = "usuario_fecha_nacimiento")
	private String fechaNaimiento;
	
	@Column(name = "usuario_sexo")
	private String sexo;
	
	@Column(name = "usuario_dni")
	private String dni;
	
	@Column(name = "usuario_correo")
	private String correo;
	
	@Column(name = "usuario_clave")
	private String clave;
	
	@OneToOne(mappedBy = "usuario")
	private Paciente paciente;
	
	@OneToOne(mappedBy = "usuario")
	private Medico medico;
	
}
