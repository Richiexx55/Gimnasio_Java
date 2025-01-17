CREATE DATABASE gymescorpion;
USE gymescorpion;
DROP DATABASE gymescorpion;
DROP TABLE Usuario;
-- Activo, Inactivo, Baneado

CREATE TABLE Estado(
idEstado INT PRIMARY KEY NOT NULL auto_increment,
Estado VARCHAR(10) NOT NULL
);

INSERT INTO Estado(Estado) VALUES 
('activo'),
('inactivo'),
('baneado');

CREATE TABLE tipo_usuario(
id_tipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
rol VARCHAR(10)
);

INSERT INTO tipo_usuario(rol) VALUES 
('admin'),
('trabajador'),
('visita'),
('socio');

CREATE TABLE Usuario(
idUsuario INT PRIMARY KEY NOT NULL auto_increment,
idEstado INT NOT NULL DEFAULT '1',
Usur VARCHAR(45) NULL,
Nombre VARCHAR(45) NULL,
pass VARCHAR(100) NULL,
id_tipo INT DEFAULT '2',
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE
);

/*SHA1*/
INSERT INTO Usuario(Usur, Nombre, pass, id_tipo) VALUES
('admin', 'admin', sha1('pass'), '1');

INSERT INTO Usuario(Usur, Nombre, pass, id_tipo) VALUES
('emp', 'Socio', sha1('clave'), '2');

SELECT * FROM Usuario;

-- HASTA AQUI SE ESTÁN HACIENDO COMPROBACION BD JAVA

-- Los clientes del gimnasio
CREATE TABLE Socio(
idSocio INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NOT NULL,
fechaCreacion DATETIME NULL,
Nombre VARCHAR(45) NULL,
Paterno VARCHAR(45) NULL,
Materno VARCHAR(45) NULL,
Tel VARCHAR(45) NULL,
-- Observaciones VARCHAR(500) NULL,
idUsuarioCreo INT NULL,
FOREIGN KEY (idEstado) REFERENCES Estado(idEstado) 
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);

-- Sucursales FALTA TERMINAR
CREATE TABLE Sucursal(
idSucursal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- direccion VARCHAR(50),
Nombre VARCHAR(45),
Tel VARCHAR(10),
idUsuario INT NOT NULL,
miembros INT NULL,
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (miembros) REFERENCES Socio(idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);

-- Membresia de los clientes delee gimnasio
CREATE TABLE Membresia(
idMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(45) NULL,
-- idEstados INT NULL,
fechaCreacion DATETIME NULL,
Precio DECIMAL (8, 2) NULL,
idUsuarioCreo INT NULL,
meses INT NULL COMMENT 'meses de la membresia',
horaInicio TIME NULL,
horaFinal TIME NULL,
-- FOREIGN KEY (idEstados) REFERENCES Estado(idEstados)
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE
);


-- Membresia de socios

CREATE TABLE SocioMembresia(
idSocioMembresia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idEstado INT NULL,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NULL,
idMembresia INT NULL,
Precio DECIMAL (8,2) NULL,
fechaInicioMembresia DATETIME NULL,
FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio(idSocio)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idMembresia) REFERENCES Membresia (idMembresia)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Entrada(
idEntrada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idEstados INT NULL DEFAULT 1,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NOT NULL,
-- Total DECIMAL (8, 2) NULL,
-- FOREIGN KEY (idEstados) REFERENCES Estado (idEstados)
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario(idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Salida(
idSalida INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idEstado INT NULL,
fechaCreacion DATETIME NULL,
idUsuarioCreo INT NULL,
idSocio INT NOT NULL,
-- FOREIGN KEY (idEstado) REFERENCES Estado (idEstado) 
-- ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idUsuarioCreo) REFERENCES Usuario (idUsuario)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);
/*
CREATE TABLE DetalleSalida(
idDetalleSalida INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
idSalida INT NULL,
FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idSalida) REFERENCES Salida (idSalida)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
/*
CREATE TABLE DetalleEntrada(
idDetalleEntrada INT NOT NULL AUTO_INCREMENT,
idProducto INT NULL,
CostoUnitario DECIMAL(8, 2) NULL,
idEntrado INT NULL,
idDetalleSalida INT NULL,
FOREIGN KEY (idEntrada) REFERENCES Entrada (idEntrada)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (idDetalleSalida) REFERENCES DetalleSalida (idDetalleSalida)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
/*
CREATE TABLE Registro(
idRegistro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idSocio INT NULL,
fechaCreacion DATETIME NULL,
FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
ON DELETE CASCADE ON UPDATE CASCADE
);
*/
CREATE TABLE Visita(
idVisita INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- idSocio INT NULL,
Nombre VARCHAR(50),
Paterno VARCHAR(50),
fechaCreacion DATETIME NULL,
precioVisita DECIMAL(8, 2) NULL
-- FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
-- ON DELETE CASCADE ON UPDATE CASCADE
);


DROP DATABASE gymescorpion;