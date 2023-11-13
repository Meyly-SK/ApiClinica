package com.proyecto.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
    private String sexo;
    private String dni;
	private String correo;
	private String clave;
}
