package com.proyecto.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita implements Serializable {

	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	Long id;
	
	@Column(name = "cita_fecha_hora")
	Date fecha_cita;
	
	@Column(name = "cita_motivo")
	String motivo;
	
	@OneToOne
	@JoinColumn(name = "")
	private 
	
	
	
}
