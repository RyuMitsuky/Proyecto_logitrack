# LogiTrack API

> API REST para gestión de inventario y logística empresarial.

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.5-6DB33F?style=flat&logo=springboot&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=flat&logo=mariadb&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=flat&logo=jsonwebtokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=black)

---

## Descripción

LogiTrack es una API REST desarrollada con Spring Boot que permite gestionar el inventario y la logística de una empresa. Incluye autenticación con JWT, documentación interactiva con Swagger y una arquitectura en capas bien definida.

---

## Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 17 | Lenguaje principal |
| Spring Boot | 3.5 | Framework base |
| Spring Security | 3.5 | Autenticación y autorización |
| JPA / Hibernate | — | Persistencia de datos |
| MariaDB | — | Base de datos relacional |
| Lombok | — | Reducción de boilerplate |
| SpringDoc OpenAPI | 2.8 | Documentación Swagger |
| JWT (JJWT) | — | Tokens de autenticación |

---

## Arquitectura

El proyecto sigue una arquitectura en capas estándar:
```
com.example.LogiTrack/
├── Controller/       → Recibe las peticiones HTTP
├── Service/          → Lógica de negocio (interfaz + impl)
├── Repository/       → Acceso a base de datos (JPA)
├── Model/            → Entidades JPA
├── Dto/
│   ├── request/      → Datos de entrada
│   └── response/     → Datos de salida
├── mapper/           → Conversión entre entidades y DTOs
├── auth/             → Login y generación de JWT
├── config/           → SecurityConfig, JwtFilter, JwtService
└── exception/        → GlobalExceptionHandler, BusinessRuleException
```

---

## Requisitos previos

- Java 17+
- Maven 3.8+
- MariaDB o MySQL corriendo localmente

---

## Cómo ejecutar

**1. Clonar el repositorio**
```bash
git clone https://github.com/tu-usuario/LogiTrack.git
cd LogiTrack
```

**2. Crear la base de datos**

Ejecutar el script SQL de la sección [Base de datos](#base-de-datos) en tu cliente MySQL/MariaDB.

**3. Configurar la conexión**

Editar `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/LogiTrack
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

**4. Ejecutar**
```bash
./mvnw spring-boot:run
```

El servidor queda disponible en `http://localhost:8080`.

---

## Autenticación

La API usa **JWT Bearer Token**. Para acceder a los endpoints protegidos:

**1. Obtener el token:**
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "1234"
}
```

**2. Usar el token en cada petición:**
```http
Authorization: Bearer <token>
```

---

## Endpoints

### Usuarios — `/usuarios`

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/usuarios` | Listar todos |
| `GET` | `/usuarios/{id}` | Buscar por ID |
| `POST` | `/usuarios` | Crear nuevo |
| `PUT` | `/usuarios/{id}` | Actualizar |
| `DELETE` | `/usuarios/{id}` | Eliminar |

### Bodegas — `/bodegas`

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/bodegas` | Listar todas |
| `GET` | `/bodegas/{id}` | Buscar por ID |
| `POST` | `/bodegas` | Crear nueva |
| `PUT` | `/bodegas/{id}` | Actualizar |
| `DELETE` | `/bodegas/{id}` | Eliminar |

### Productos — `/productos`

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/productos` | Listar todos |
| `GET` | `/productos/{id}` | Buscar por ID |
| `POST` | `/productos` | Crear nuevo |
| `PUT` | `/productos/{id}` | Actualizar |
| `DELETE` | `/productos/{id}` | Eliminar |

---

## Documentación interactiva

La documentación Swagger está disponible con el servidor corriendo en:
```
http://localhost:8080/swagger-ui.html
```

---

## Base de datos
```sql
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

-- Datos de prueba
INSERT INTO usuarios (username, password, rol) VALUES
  ('admin', 'admin123', 'ADMIN'),
  ('juan', 'juan123', 'EMPLEADO'),
  ('maria', 'maria123', 'EMPLEADO');

INSERT INTO bodegas (nombre, ubicacion, capacidad, encargado) VALUES
  ('Bodega Central', 'Cali', 1000, 'Carlos'),
  ('Bodega Norte', 'Cali Norte', 500, 'Laura');

INSERT INTO productos (nombre, descripcion, precio, stock) VALUES
  ('Laptop', 'Laptop empresarial', 2500.00, 10),
  ('Mouse', 'Mouse inalambrico', 50.00, 100);

INSERT INTO movimientos (tipo, usuario_id, bodega_id) VALUES ('ENTRADA', 1, 1);

INSERT INTO movimiento_producto (movimiento_id, producto_id, cantidad) VALUES
  (1, 1, 2),
  (1, 2, 5);
```

---

## Repositorio relacionado

- Frontend: [LogiTrack Frontend](https://github.com/RyuMitsuky/BackEnd_LogiTrack)