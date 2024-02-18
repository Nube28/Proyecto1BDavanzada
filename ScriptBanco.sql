CREATE DATABASE IF NOT EXISTS banco;

USE BANCO;

CREATE TABLE IF NOT EXISTS Clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellido_paterno VARCHAR(50),
    apellido_materno VARCHAR(50),
    fecha_nacimiento DATE,
    edad INT,
    contrasenia varchar(60),
    usuario INT 
);

DELIMITER //

CREATE TRIGGER calcular_edad_cliente
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());
END;
//

DELIMITER //
CREATE TRIGGER incrementar_usuario
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    DECLARE max_usuario INT;
    SELECT MAX(usuario) INTO max_usuario FROM Clientes;
    
    IF max_usuario IS NULL THEN
        SET NEW.usuario = 1;
    ELSE
        SET NEW.usuario = max_usuario + 1;
    END IF;
END;
//
DELIMITER ;


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
    activo boolean,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);
DELIMITER //

CREATE TRIGGER generar_fecha_hora_apertura
BEFORE INSERT ON Cuentas
FOR EACH ROW
BEGIN
    SET NEW.fecha_apertura = NOW();
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER activar_cuentas
BEFORE INSERT ON Cuentas
FOR EACH ROW
BEGIN
    SET NEW.activo = true;
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER incrementar_numero_cuetna
BEFORE INSERT ON Cuentas
FOR EACH ROW
BEGIN
    DECLARE max_numero INT;

    SELECT MAX(numero) INTO max_numero FROM Cuentas;

    IF max_numero IS NULL THEN
        SET NEW.numero = 1;
    ELSE
        SET NEW.numero = max_numero + 1;
    END IF;
END;
//

DELIMITER ;



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
    estado ENUM('cobrado', 'no cobrado','pendiente'),
    folio INT,
    contrasenia CHAR(8),
    FOREIGN KEY (id_transaccion) REFERENCES Transacciones(id)
);


DELIMITER $$
CREATE TRIGGER generar_folio_y_contrasenia
BEFORE INSERT ON SinCuenta
FOR EACH ROW
BEGIN
    DECLARE nuevo_folio INT;
    DECLARE nueva_contrasenia CHAR(8);
    
    SET nuevo_folio = FLOOR(RAND() * 900000) + 100000; 
    SET nueva_contrasenia = LPAD(FLOOR(RAND() * 100000000), 8, '0'); 
    
    SET NEW.folio = nuevo_folio;
    SET NEW.contrasenia = nueva_contrasenia;
END;
 $$
DELIMITER ;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEstadoTransaccion`(
    IN p_folio INT,
    IN p_contrasenia VARCHAR(8)
)
BEGIN
    DECLARE fecha_actual DATETIME;
    DECLARE fecha_transaccion DATETIME;
    DECLARE transaccion_id int;
    
    
    SET fecha_actual = NOW();
    
	SELECT id_transaccion INTO transaccion_id FROM SinCuenta WHERE folio = p_folio AND contrasenia = p_contrasenia;
SELECT fecha INTO fecha_transaccion FROM Transacciones WHERE id = transaccion_id;
    
    IF TIMESTAMPDIFF(MINUTE, fecha_transaccion, fecha_actual) >= 10 THEN
        UPDATE SinCuenta SET estado = 'no cobrado' WHERE id_transaccion = transaccion_id;
        ELSE
        UPDATE SinCuenta SET estado = 'cobrado' WHERE id_transaccion = transaccion_id;

    END IF;
END $$

DELIMITER ;

