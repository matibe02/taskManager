# Imagen base de Java
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copio el archivo jar compilado
COPY target/taskManager-0.0.1-SNAPSHOT.jar app.jar

# Expongo el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]