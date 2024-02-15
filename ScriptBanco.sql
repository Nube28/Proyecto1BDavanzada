CREATE DATABASE IF NOT EXISTS banco;

USE BANCO;

CREATE TABLE IF NOT EXISTS Clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellido_paterno VARCHAR(50),
    apellido_materno VARCHAR(50),
    fecha_nacimiento DATE,
    edad INT,
    contrasenia INT(50),
    usuario INT unique
);

CREATE TABLE IF NOT EXISTS Domicilios (
    id INT PRIMARY KEY auto_increment,
    calle VARCHAR(100),
    numero_exterior INT,
    numero_interior INT,
    codigo_postal VARCHAR(5),
    colonia VARCHAR(100),
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES Domicilios(id)
);

CREATE TABLE IF NOT EXISTS Cuentas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_apertura DATE,
    numero INT UNIQUE,
    saldo FLOAT,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);

CREATE TABLE IF NOT EXISTS Transacciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    monto FLOAT,
    tipo VARCHAR(20),
    fecha DATETIME,
    id_cuenta INT,
    FOREIGN KEY (id_cuenta) REFERENCES Cuentas(id)
);

DELIMITER //
CREATE TRIGGER generar_fecha_hora
BEFORE INSERT ON Transacciones
FOR EACH ROW
BEGIN
    SET NEW.fecha = NOW();
END;
//

DELIMITER ;

CREATE TABLE IF NOT EXISTS Transferencia (
    id_transaccion INT,
    id_cuenta_destino INT,
    FOREIGN KEY (id_transaccion) REFERENCES Transacciones(id),
    FOREIGN KEY (id_cuenta_destino) REFERENCES Cuentas(id)
);

CREATE TABLE IF NOT EXISTS SinCuenta (
    id_transaccion INT,
    estado ENUM('cobrado', 'no cobrado'),
    folio INT,
    contrasenia CHAR(8),
    FOREIGN KEY (id_transaccion) REFERENCES Transacciones(id)
);





