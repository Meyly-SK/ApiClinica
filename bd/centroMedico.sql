DROP DATABASE IF EXISTS centroMedico;
CREATE DATABASE centroMedico;
USE centroMedico;

CREATE TABLE usuario (
  usuario_id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_nombre VARCHAR(150) NOT NULL,
  usuario_apellido VARCHAR(150) NOT NULL,
  usuario_fecha_nacimiento DATE NOT NULL,
  usuario_sexo VARCHAR(1) NOT NULL,
  usuario_dni VARCHAR(8) NOT NULL,
  usuario_correo VARCHAR(150) NOT NULL,
  usuario_clave VARCHAR(150) NOT NULL,
  usuario_role VARCHAR(15) NOT NULL
);

CREATE TABLE paciente (
  paciente_id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
);

CREATE TABLE medico (
  medico_id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  medico_especialidad VARCHAR(150) NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
);

CREATE TABLE cita (
  cita_id INT PRIMARY KEY AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  cita_fecha_hora DATETIME NOT NULL,
  cita_motivo VARCHAR(150) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente (paciente_id),
  FOREIGN KEY (medico_id) REFERENCES medico (medico_id)
);

CREATE TABLE historial_clinico (
  historial_clinico_id INT PRIMARY KEY AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  historial_clinico_fecha DATE NOT NULL,
  historial_clinico_diagnostico VARCHAR(150) NOT NULL,
  historial_clinico_tratamiento VARCHAR(150) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente (paciente_id),
  FOREIGN KEY (medico_id) REFERENCES medico (medico_id)
);
/*
CREATE TABLE receta (
  receta_id INT PRIMARY KEY AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  receta_fecha DATE NOT NULL,
  receta_medicamentos VARCHAR(150) NOT NULL,
  receta_dosis VARCHAR(150) NOT NULL,
  receta_frecuencia VARCHAR(150) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente (paciente_id),
  FOREIGN KEY (medico_id) REFERENCES medico (medico_id)
);

CREATE TABLE factura (
  factura_id INT PRIMARY KEY AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  factura_fecha DATE NOT NULL,
  factura_importe DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente (paciente_id)
);
*/

INSERT INTO usuario
VALUES (null, 'Juan', 'Pérez', '1990-01-01', 'M', '12345678', 'juan.perez@example.com', '$2a$12$0U0VTCxsWnOI3zvWTFodw.OXM3FaO4UKRBAzGgU0ote5nb4L8j42q', 'PACIENTE'),
(null, 'María', 'González', '1995-02-02', 'F', '87654321', 'maria.gonzalez@example.com', '$2a$12$3/GQ23h1ccc/P/LGyiSq0O6Ij7BaxQ2/AA8e4PYorZBk6chN3B7l.', 'PERSONAL_MEDICO'),
(null, 'Pedro', 'Rodríguez', '2000-03-03', 'M', '34567801', 'pedro.rodriguez@example.com', '$2a$12$/fyycK/6rB79Qc1.BlE/3.Yj0FEuQgqebYCpzrkA424IIPCpD81mO', 'PERSONAL_MEDICO');

INSERT INTO paciente
VALUES (null, 1);

INSERT INTO medico
VALUES (null, 2, 'Médico general'),
(null, 3, 'Traumatólogo');
-- (null, 4, 'Pediatra');

SELECT * FROM usuario;
SELECT * FROM paciente;
SELECT * FROM medico;
-- SELECT * FROM receta;