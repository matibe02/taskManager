# Gestor de Tareas

## Descripción
Gestor de Tareas es una aplicación full-stack desarrollada en Java con Spring Boot. Permite crear, editar, listar y eliminar tareas. Este proyecto está pensado como parte de mi portfolio para demostrar habilidades de backend y full-stack, incluyendo integración con base de datos, dockerización, seguridad, microservicios y APIs de terceros (en desarrollo).

## Tecnologías
- **Backend:** Java 17, Spring Boot, JPA/Hibernate
- **Base de datos:** PostgreSQL
- **Frontend:** Thymeleaf (básico, en desarrollo)
- **Contenedores:** Docker (backend y base de datos)
- **Testing:** JUnit / Mockito (en desarrollo)
- **Documentación API:** Swagger (en desarrollo)

## Funcionalidades actuales
- CRUD completo de tareas (crear, editar, listar, eliminar)
- Conexión a PostgreSQL mediante JPA/Hibernate
- Frontend básico con Thymeleaf para visualizar y agregar tareas
- Proyecto dockerizado (backend + base de datos)

## Roadmap / Sprints futuros
- **Sprint 1:** Dockerizar backend y base de datos
- **Sprint 2:** Implementar seguridad con Spring Security
- **Sprint 3:** Microservicios
- **Sprint 4:** Integración con APIs de terceros
- **Sprint 5:** Frontend avanzado, pruebas unitarias y documentación con Swagger

## Cómo ejecutar el proyecto
1. Clonar el repositorio:
```bash
git clone https://github.com/matibe02/taskManager
```
2. Configurar PostgreSQL (usuario, contraseña y base de datos) en application.properties
3.  Levantar la aplicación: ./mvnw spring-boot:run
4. Acceder al frontend básico: http://localhost:8080/
   
## Notas

Proyecto en desarrollo, ideal para portfolio de backend y full-stack Java.
Las funcionalidades avanzadas (seguridad, microservicios, APIs de terceros) se encuentran en roadmap.