CREATE TABLE IF NOT EXISTS employee (
    numero_documento VARCHAR(15) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(5),
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    fecha_nacimiento DATE,
    fecha_vinculacion DATE,
    cargo VARCHAR(255),
    salario DOUBLE(10, 2)
);