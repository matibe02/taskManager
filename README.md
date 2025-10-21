# Gestor de Tareas

## Descripción

Gestor de Tareas es una aplicación full-stack desarrollada en Java con Spring Boot. Permite crear, editar, listar y eliminar tareas. Este proyecto está pensado como parte de mi portfolio para demostrar habilidades de backend y full-stack, incluyendo integración con base de datos, dockerización y seguridad básica. Actualmente el frontend se realiza con Thymeleaf y se planea migrar a un frontend moderno más adelante.

## Tecnologías

- **Backend:** Java 21, Spring Boot 3.5.6, JPA/Hibernate
- **Base de datos:** PostgreSQL
- **Frontend:** Thymeleaf (básico)
- **Seguridad:** Spring Security con JWT (implementación en proceso)
- **Contenedores:** Docker (backend y base de datos, pendientes de migración a Fedora)
- **Testing:** JUnit / Mockito (en desarrollo)
- **Documentación API:** Swagger (en desarrollo)

## Estructura del proyecto

- **Config:** `JwtAuthenticationFilter`, `JwtUtil`, `SecurityConfig`
- **Controller:** `AuthController`, `HomeController`, `TaskController`, `TaskViewController`
- **DTO:** `RegisterDTO`, `TaskDTO`
- **Exception:** `GlobalExceptionHandle`, `TaskNotFoundException`
- **Mapper:** `TaskMapper`
- **Model:** `AppUser`, `Task`, `TaskState`
- **Repository:** `TaskRepository`, `UserRepository`
- **Service:** `CustomUserDetailsService`, `TaskService`, `UserService`
- **Templates HTML:** `edit-task.html`, `login.html`, `register.html`, `tasks.html`

## Funcionalidades actuales

- CRUD completo de tareas (crear, editar, listar, eliminar)
- Conexión a PostgreSQL mediante JPA/Hibernate
- Frontend básico con Thymeleaf para visualizar y agregar tareas
- Proyecto dockerizado (backend + base de datos)
- Seguridad básica con Spring Security; JWT ya configurado pero REST Controllers en proceso

## Cambios recientes

- Migración a **Java 21** y Spring Boot 3.5.6
- Ejecución en **Fedora**, ajustes en dependencias
- Seguridad con JWT configurada, STATELESS temporalmente deshabilitado para compatibilidad con Thymeleaf
- Preparación para migración futura a REST Controllers

## Roadmap / Sprints futuros

- Implementar REST Controllers y probar APIs con Postman
- Mejorar frontend: migración de Thymeleaf a un framework moderno (React, Angular, Vue)
- Integración con APIs de terceros
- Pruebas unitarias y documentación con Swagger
- Refactor y mejora de seguridad completa (JWT y roles de usuario)

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/matibe02/taskManager
```
2. Configurar PostgreSQL (usuario, contraseña y base de datos) en application.properties

3. Levantar la aplicación

```bash
./mvnw spring-boot:run
```

4. Acceder al frontend básico:
http://localhost:8080/

## Notas

Proyecto en desarrollo, ideal para portfolio de backend y full-stack Java. Las funcionalidades avanzadas (REST, APIs de terceros, frontend moderno) se encuentran en roadmap.