package com.proyecto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita" )
public class Cita implements Serializable{

	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "cita_id")
	private Long cita_id;
	
	@Column(name = "cita_fecha_hora")
	private Date cita_fecha;
	
	@Column(name = "cita_motivo")
	private String cita_motivo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
}
