# LogiTrack API

API REST para gestión de inventario y logística.

## Tecnologías

- Java 17
- Spring Boot
- JPA / Hibernate
- MariaDB
- Swagger

## Arquitectura

Controller
Service
Repository
DTO
Mapper
GlobalExceptionHandler

## Endpoints principales

Usuarios
Bodegas
Productos

## Documentación

Disponible en:

http://localhost:8080/swagger-ui.html

## BBDD

DROP DATABASE IF EXISTS LogiTrack;
CREATE DATABASE LogiTrack;
USE LogiTrack;

CREATE TABLE usuarios (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL,
rol VARCHAR(20) NOT NULL
);

CREATE TABLE bodegas (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
ubicacion VARCHAR(100) NOT NULL,
capacidad INT NOT NULL,
encargado VARCHAR(100)
);

CREATE TABLE productos (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripcion VARCHAR(200),
precio DECIMAL(10,2) NOT NULL,
stock INT NOT NULL
);

CREATE TABLE movimientos (
id INT AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(20) NOT NULL,
fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
usuario_id INT NOT NULL,
bodega_id INT NOT NULL,
FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
);

CREATE TABLE movimiento_producto (
id INT AUTO_INCREMENT PRIMARY KEY,
movimiento_id INT NOT NULL,
producto_id INT NOT NULL,
cantidad INT NOT NULL,
FOREIGN KEY (movimiento_id) REFERENCES movimientos(id),
FOREIGN KEY (producto_id) REFERENCES productos(id)
);

INSERT INTO usuarios (username, password, rol) VALUES
('admin','admin123','ADMIN'),
('juan','juan123','EMPLEADO'),
('maria','maria123','EMPLEADO');

INSERT INTO bodegas (nombre, ubicacion, capacidad, encargado) VALUES
('Bodega Central','Cali',1000,'Carlos'),
('Bodega Norte','Cali Norte',500,'Laura');

INSERT INTO productos (nombre, descripcion, precio, stock) VALUES
('Laptop','Laptop empresarial',2500.00,10),
('Mouse','Mouse inalambrico',50.00,100);

INSERT INTO movimientos (tipo, usuario_id, bodega_id)
VALUES ('ENTRADA',1,1);

INSERT INTO movimiento_producto (movimiento_id, producto_id, cantidad) VALUES
(1,1,2),
(1,2,5);