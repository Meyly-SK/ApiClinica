package com.proyecto.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	private int  id;
	
	@Column(name = "cita_fecha_hora")
	private String fechaHora;
	
	@Column(name = "cita_motivo")
	private String motivo;
	
	@ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
