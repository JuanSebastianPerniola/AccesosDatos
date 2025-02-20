# Microservicio CRUD con Spring Boot y SQLite

## Descripción
Este proyecto es un microservicio REST desarrollado con Spring Boot que permite gestionar productos almacenados en una base de datos SQLite. Implementa operaciones CRUD (Create, Read, Update, Delete) mediante endpoints expuestos en formato JSON.

## Tecnologías utilizadas
- **Java JDK 21**
- **Spring Boot 3.4.2**
- **Spring Data JPA** (para la gestión de persistencia)
- **SQLite** (base de datos ligera y embebida)
- **Hibernate** (como implementación de JPA)
- **Spring Boot Actuator** (para monitorización)
- **Spring Boot HATEOAS** (para hipermedios en las respuestas REST)

## Estructura del Proyecto
```
com.example.demo
├── DemoApplication.java   # Clase principal
├── Producto.java          # Entidad JPA para productos
├── ProductoController.java # Controlador REST
├── ProductoService.java   # Servicio de negocio
├── ProductoManagement.java # Lógica adicional para productos
```

## Configuración de la Base de Datos
La base de datos SQLite se encuentra en el archivo `Producto.db` y se configura en `application.properties`:
```properties
spring.datasource.url=jdbc:sqlite:Producto.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
```

## Endpoints de la API
| Método | URL                | Descripción |
|---------|------------------|-------------|
| POST    | /producto       | Crear un nuevo producto |
| GET     | /producto       | Obtener todos los productos |
| GET     | /producto/{id}  | Obtener un producto por ID |
| PUT     | /producto/{id}  | Actualizar un producto existente |
| DELETE  | /producto/{id}  | Eliminar un producto |

## Instalación y Ejecución
### 1. Deserializar el zip

### 2. Compilar y ejecutar con Maven
```bash
mvn spring-boot:run
```