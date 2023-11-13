package com.proyecto.model;

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
@Table(name = "historial_clinico")
public class Historial_Clinico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "historial_clinico_id")
	private int id;
	
	@Column(name = "historial_clinico_fecha")
	private String fecha;
	
	@Column(name = "historial_clinico_diagnostico")
	private String diagnostico;
	
	@Column(name = "historial_clinico_tratamiento")
	private String tratamineto;
	
	@ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteH;
	
	@ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoH;

}
